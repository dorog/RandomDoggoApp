package bme.hu.randomdoggo.ui.main

import androidx.fragment.app.Fragment
import bme.hu.randomdoggo.model.RandomDoggo

interface MainScreen {
    fun showFragment(fragment: Fragment)
    fun showDetails(randomDoggo: RandomDoggo)
}