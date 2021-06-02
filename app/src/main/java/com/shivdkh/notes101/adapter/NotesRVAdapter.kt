package com.shivdkh.notes101.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shivdkh.notes101.R
import com.shivdkh.notes101.dataClass.NotesData

class NotesRVAdapter(private val context: Context, private val listener: IVNotesAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<NotesData>()

    //Get the item view as view holder
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textViewNotes)
        val btnDelete: ImageView = itemView.findViewById(R.id.img_delete_btn)
        val tv_id: TextView= itemView.findViewById(R.id.textViewIDNotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val viewHolder =
            NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_item, parent, false))
        viewHolder.btnDelete.setOnClickListener{
            listener.onItemClick(allNotes[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = allNotes[position]
        holder.textView.text=current.text
        holder.tv_id.text= current.id.toString()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<NotesData>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface IVNotesAdapter{
    fun onItemClick(notesData: NotesData)
}