package bme.hu.randomdoggo.ui.favourites

import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.ui.Presenter
import javax.inject.Inject

class FavouritesPresenter @Inject constructor(): Presenter<FavouritesScreen>() {

    fun removeRandomDoggoFromDatabase(randomDoggo: RandomDoggo){
        screen!!.removeRandomDoggoFromDatabase(randomDoggo)
    }
}