package bme.hu.randomdoggo.ui.search

import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.ui.Presenter
import javax.inject.Inject

class SearchPresenter  @Inject constructor(private val randomDoggoInteractor: RandomDoggoInteractor): Presenter<SearchScreen>() {

    override fun attachScreen(screen: SearchScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun searchRandomDoggo(){}

    fun addRandomDoggoToDatabase(){}
}