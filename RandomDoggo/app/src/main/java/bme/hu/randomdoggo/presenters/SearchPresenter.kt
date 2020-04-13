package bme.hu.randomdoggo.presenters

import bme.hu.randomdoggo.interactors.NetworkInteractor
import bme.hu.randomdoggo.presenters.abstracts.ExtendedPresenter
import bme.hu.randomdoggo.views.interfaces.SearchScreen

const val url : String = ""

object SearchPresenter : ExtendedPresenter<SearchScreen>() {

    private var networkInteractor : NetworkInteractor = NetworkInteractor()

    override fun attachScreen(screen: SearchScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun searchRandomDoggo(){}

    fun addRandomDoggoToDatabase(){}
}