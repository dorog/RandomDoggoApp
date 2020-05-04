package bme.hu.randomdoggo.ui.main

import bme.hu.randomdoggo.ui.Presenter
import bme.hu.randomdoggo.ui.details.DetailsFragment
import bme.hu.randomdoggo.ui.favourites.FavouritesFragment
import bme.hu.randomdoggo.ui.search.SearchFragment

class MainPresenter : Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun showSearchFragment(){
        screen!!.showFragment(SearchFragment())
    }

    fun showFavouritesFragment(){
        screen!!.showFragment(FavouritesFragment())
    }

    fun showDetailsFragment(){
        screen!!.showFragment(DetailsFragment())
    }

    fun showCreditsFragment(){
        //screen!!.showFragment(CreditsFragment())
    }
}