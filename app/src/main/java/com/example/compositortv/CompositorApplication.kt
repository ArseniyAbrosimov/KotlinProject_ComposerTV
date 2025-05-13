package com.example.compositortv

import android.app.Application
import com.example.compositortv.data.AppContainer
import com.example.compositortv.data.DefaultAppContainer

class CompositorApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
