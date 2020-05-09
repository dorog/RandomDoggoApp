package bme.hu.randomdoggo.ui.favourites

import bme.hu.randomdoggo.model.RandomDoggo

interface FavouritesScreen {
    fun showFavourites()
    fun removeRandomDoggoFromDatabase(randomDoggo: RandomDoggo)
}