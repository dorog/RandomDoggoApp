package bme.hu.randomdoggo.presenters

import bme.hu.randomdoggo.presenters.abstracts.ExtendedPresenter
import bme.hu.randomdoggo.views.interfaces.FavouritesScreen

object FavouritesPresenter : ExtendedPresenter<FavouritesScreen>() {

    override fun attachScreen(screen: FavouritesScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun getAllRandomDoggoFromDatabase(){}
}