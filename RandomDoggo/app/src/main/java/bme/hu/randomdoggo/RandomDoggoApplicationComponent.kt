package bme.hu.randomdoggo

import bme.hu.randomdoggo.interactor.InteractorModule
import bme.hu.randomdoggo.network.NetworkModule
import bme.hu.randomdoggo.ui.UIModule
import bme.hu.randomdoggo.ui.details.DetailsFragment
import bme.hu.randomdoggo.ui.favourites.FavouritesActivity
import bme.hu.randomdoggo.ui.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface RandomDoggoApplicationComponent {
    fun inject(searchActivity: SearchActivity)
    fun inject(favouritesActivity: FavouritesActivity)
    fun inject(detailsFragment: DetailsFragment)
}