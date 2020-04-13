package bme.hu.randomdoggo.views.interfaces

import bme.hu.randomdoggo.models.RandomDoggo

interface SearchScreen {
    fun searchRandomDoggo()
    fun addRandomDoggoToFavourites(randomDoggo: RandomDoggo)
}