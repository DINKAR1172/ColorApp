package com.example.colorapp.Model

import androidx.room.RoomDatabase

@androidx.room.Database(
    entities = [Colours::class],
    exportSchema = false,
    version = 1
    )
 abstract class Database():RoomDatabase(){
    abstract fun CDao():ColorDao
}