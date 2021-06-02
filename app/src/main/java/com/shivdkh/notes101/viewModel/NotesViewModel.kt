package com.shivdkh.notes101.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.shivdkh.notes101.dataClass.NotesData
import com.shivdkh.notes101.database.DatabaseNotes
import com.shivdkh.notes101.repositary.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    val allNotesData: LiveData<List<NotesData>>
    val repository: NotesRepository

    init {
        val database = DatabaseNotes.getDatabase(application)
        val dao = database.getNotesDao()
        repository = NotesRepository(dao)
        allNotesData = repository.allNotesData
    }

    fun deleteNote(notesDataToBeDeleted: NotesData) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notesDataToBeDeleted)
    }
    fun addNote(noteToBeAdded: NotesData) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(noteToBeAdded)
    }

}