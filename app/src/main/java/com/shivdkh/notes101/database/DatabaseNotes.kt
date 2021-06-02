package com.shivdkh.notes101.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shivdkh.notes101.dao.NotesDao
import com.shivdkh.notes101.dataClass.NotesData

@Database(entities = [NotesData::class], version = 2, exportSchema = false)
abstract class DatabaseNotes : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseNotes? = null
        fun getDatabase(context: Context): DatabaseNotes {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseNotes::class.java,
                    "notes_table"
                ).build()
                INSTANCE=instance
                instance
            }
        }
    }
}