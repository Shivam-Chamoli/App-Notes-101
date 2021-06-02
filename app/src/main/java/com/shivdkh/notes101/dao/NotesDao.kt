package com.shivdkh.notes101.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shivdkh.notes101.dataClass.NotesData

@Dao
interface NotesDao {

    @Insert
    suspend fun insert(note: NotesData)

    @Delete
    suspend fun delete(note:NotesData)

    @Query("SELECT * FROM notes_table order by  id ASC")
    fun getAllNotes(): LiveData<List<NotesData>>
}