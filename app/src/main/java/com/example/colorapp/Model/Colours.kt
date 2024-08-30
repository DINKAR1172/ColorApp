package com.example.colorapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("Color")
data class Colours(
@PrimaryKey(autoGenerate = true)
    val id:Long=0L,
    @ColumnInfo("Color_id")
    val Colorid:String="",
    @ColumnInfo("Date&Time")
    val TimeStamp:Long=0L
)
