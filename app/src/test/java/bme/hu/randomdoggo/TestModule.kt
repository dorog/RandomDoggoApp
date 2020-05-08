package bme.hu.randomdoggo

import android.content.Context
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.ui.favourites.FavouritesPresenter
import bme.hu.randomdoggo.ui.search.SearchPresenter
import bme.hu.randomdoggo.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule (private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideFavouritesPresenter(randomDoggoRepository: RandomDoggoRepository) = FavouritesPresenter(randomDoggoRepository)

    @Provides
    @Singleton
    fun provideSearchPresenter(executor: Executor, randomDoggoInteractor: RandomDoggoInteractor, randomDoggoRepository: RandomDoggoRepository) = SearchPresenter(executor, randomDoggoInteractor, randomDoggoRepository)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}