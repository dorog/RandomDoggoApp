package bme.hu.randomdoggo.ui

import android.content.Context
import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.ui.details.DetailsPresenter
import bme.hu.randomdoggo.ui.favourites.FavouritesPresenter
import bme.hu.randomdoggo.ui.search.SearchPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun searchPresenter(randomDoggoInteractor : RandomDoggoInteractor) = SearchPresenter(randomDoggoInteractor)

    @Provides
    @Singleton
    fun favouritesPresenter(randomDoggoInteractor : RandomDoggoInteractor) = FavouritesPresenter(randomDoggoInteractor)

    @Provides
    @Singleton
    fun detailsPresenter(randomDoggoInteractor : RandomDoggoInteractor) = DetailsPresenter(randomDoggoInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}