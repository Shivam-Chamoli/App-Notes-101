package com.shivdkh.notes101.repositary

import androidx.lifecycle.LiveData
import com.shivdkh.notes101.dao.NotesDao
import com.shivdkh.notes101.dataClass.NotesData

class NotesRepository(private val notesDao: NotesDao) {

    val allNotesData: LiveData<List<NotesData>> =notesDao.getAllNotes()

    //creating functions which call function of dao
    suspend fun insert(note: NotesData){
        notesDao.insert(note)
    }
    suspend fun delete(note: NotesData){
        notesDao.delete(note)
    }

}