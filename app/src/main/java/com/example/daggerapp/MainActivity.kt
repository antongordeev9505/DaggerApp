package com.example.daggerapp

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MyApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

//to get component from application context, since component is saved there
val Context.getAppComponent: AppComponent
    get() = when(this) {
        is MyApp -> appComponent
        else -> this.applicationContext.getAppComponent
    }


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var plane: Plane

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAppComponent.inject(this)
    }
}