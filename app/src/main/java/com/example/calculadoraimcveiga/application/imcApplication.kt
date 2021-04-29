package com.example.calculadoraimcveiga.application

import android.app.Application
import com.example.calculadoraimcveiga.helper.HelperDB

class imcApplication : Application() {
    var helperDB : HelperDB? = null
        private set



    override fun onCreate() {
        super.onCreate()
        helperDB = HelperDB(this)
    }
}