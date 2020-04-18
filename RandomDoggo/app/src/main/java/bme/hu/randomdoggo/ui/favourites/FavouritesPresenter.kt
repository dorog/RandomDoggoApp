package bme.hu.randomdoggo.ui.favourites

import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.ui.Presenter
import javax.inject.Inject

class FavouritesPresenter  @Inject constructor(protected val randomDoggoInteractor: RandomDoggoInteractor) : Presenter<FavouritesScreen>() {

    override fun attachScreen(screen: FavouritesScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun getAllRandomDoggoFromDatabase(){}
}