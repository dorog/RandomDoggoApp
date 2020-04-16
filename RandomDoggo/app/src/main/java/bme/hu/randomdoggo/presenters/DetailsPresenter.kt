package bme.hu.randomdoggo.presenters

import bme.hu.randomdoggo.presenters.abstracts.ExtendedPresenter
import bme.hu.randomdoggo.views.interfaces.DetailsScreen

object DetailsPresenter : ExtendedPresenter<DetailsScreen>(){

    override fun attachScreen(screen: DetailsScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun removeRandomDoggoFromDatabase(id: Int){}
}
