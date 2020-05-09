package bme.hu.randomdoggo.ui.search

import bme.hu.randomdoggo.model.RandomDoggo

interface SearchScreen {
    fun searchRandomDoggo()
    fun showRandomDoggo(randomDoggo: RandomDoggo)
    fun addRandomDoggoToFavourites()
}