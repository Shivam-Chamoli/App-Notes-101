package com.shivdkh.notes101.dataClass

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class NotesData(
    @ColumnInfo(name = "note_text") val text:String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
