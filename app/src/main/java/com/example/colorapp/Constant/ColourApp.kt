package com.example.colorapp.Constant

import android.app.Application

class ColourApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}