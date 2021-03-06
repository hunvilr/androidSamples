package com.example.roompractice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    @Synchronized
    fun getInstance(context: Context) : NoteDatabase {
       if(instance == null){
            instance = Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java, "note_database")
                .fallbackToDestructiveMigration()
                .build()
        }
        return instance
    }

    companion object {
        private lateinit var instance : NoteDatabase
    }
}