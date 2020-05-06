package bme.hu.randomdoggo

import android.app.Application
import bme.hu.randomdoggo.ui.UIModule

class RandomDoggoApplication : Application() {
    lateinit var injector: RandomDoggoApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerRandomDoggoApplicationComponent.builder().uIModule(UIModule(this)).build()

    }
}