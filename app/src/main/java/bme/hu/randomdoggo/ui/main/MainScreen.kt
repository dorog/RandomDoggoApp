package bme.hu.randomdoggo.ui.main

import bme.hu.randomdoggo.model.RandomDoggo

interface MainScreen {
    fun showSearch()
    fun showFavourites()
    fun showCredits()
    fun showDetails(randomDoggo: RandomDoggo)
}