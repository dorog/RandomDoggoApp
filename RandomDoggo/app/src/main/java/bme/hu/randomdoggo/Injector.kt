package bme.hu.randomdoggo

import android.app.Activity
import androidx.fragment.app.Fragment


val Activity.injector: RandomDoggoApplicationComponent
    get() {
        return (this.applicationContext as RandomDoggoApplication).injector
    }

val Fragment.injector: RandomDoggoApplicationComponent
    get() {
        return (this.context!!.applicationContext as RandomDoggoApplication).injector
    }