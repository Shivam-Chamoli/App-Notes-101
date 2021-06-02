package com.shivdkh.notes101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivdkh.notes101.adapter.IVNotesAdapter
import com.shivdkh.notes101.adapter.NotesRVAdapter
import com.shivdkh.notes101.dataClass.NotesData
import com.shivdkh.notes101.viewModel.NotesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IVNotesAdapter {

    lateinit var viewModel:NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Making The recycler view
        rv_notes.layoutManager=LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this,this)
        rv_notes.adapter=adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NotesViewModel::class.java)
        viewModel.allNotesData.observe(this, { list->
            list?.let{
                adapter.updateList(it)}
        })
    }

    override fun onItemClick(notesData: NotesData) {
       viewModel.deleteNote(notesData)
    }

    fun addNote(view: View) {
        val noteText = et_note.text.toString()
        if (noteText.isNotEmpty()) {
            viewModel.addNote(NotesData(noteText))
        }
        et_note.setText("")
    }
}