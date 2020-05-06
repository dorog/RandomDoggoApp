package bme.hu.randomdoggo

import bme.hu.randomdoggo.interactor.InteractorModule
import bme.hu.randomdoggo.network.NetworkModule
import bme.hu.randomdoggo.ui.UIModule
import bme.hu.randomdoggo.ui.favourites.FavouritesFragment
import bme.hu.randomdoggo.ui.main.MainActivity
import bme.hu.randomdoggo.ui.search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface RandomDoggoApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(searchActivity: SearchFragment)
    fun inject(favouritesActivity: FavouritesFragment)
}