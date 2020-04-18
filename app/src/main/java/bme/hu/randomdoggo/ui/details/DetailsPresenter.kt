package bme.hu.randomdoggo.ui.details

import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.ui.Presenter
import javax.inject.Inject

class DetailsPresenter @Inject constructor(protected val randomDoggoInteractor: RandomDoggoInteractor) : Presenter<DetailsScreen>(){

    override fun attachScreen(screen: DetailsScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun removeRandomDoggoFromDatabase(id: Int){}
}
