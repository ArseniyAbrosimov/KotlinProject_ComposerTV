package com.example.composertv

import android.app.Application
import com.example.composertv.data.AppContainer
import com.example.composertv.data.DefaultAppContainer

class ComposerApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
