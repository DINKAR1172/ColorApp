package com.example.colorapp.Constant

import android.content.Context
import androidx.room.Room
import com.example.colorapp.Model.Colours
import com.example.colorapp.Model.Database
import com.example.colorapp.Model.Repository

object Graph {
    lateinit var database: Database
    val Crepository by lazy {
        Repository(database.CDao())
    }
    fun provide(Context: Context){
        database= Room.databaseBuilder(context = Context,Database::class.java,"Colour_DB").build()

    }
}