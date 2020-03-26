package com.example.snakess

import android.app.Application
import android.content.Context
import io.realm.Realm

class App:Application() {

    companion object{
        lateinit var appContext:Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
        Realm.init(this)
    }
}