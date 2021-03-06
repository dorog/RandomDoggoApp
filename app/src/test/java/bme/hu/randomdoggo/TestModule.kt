package bme.hu.randomdoggo

import android.content.Context
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.ui.favourites.FavouritesPresenter
import bme.hu.randomdoggo.ui.main.MainPresenter
import bme.hu.randomdoggo.ui.search.SearchPresenter
import bme.hu.randomdoggo.utils.UiExecutor
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule (private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideFavouritesPresenter(randomDoggoRepository: RandomDoggoRepository, scope: CoroutineScope) = FavouritesPresenter(randomDoggoRepository, scope)

    @Provides
    @Singleton
    fun provideSearchPresenter(executor: Executor, randomDoggoInteractor: RandomDoggoInteractor, randomDoggoRepository: RandomDoggoRepository, scope: CoroutineScope) = SearchPresenter(executor, randomDoggoInteractor, randomDoggoRepository, scope)

    @Provides
    @Singleton
    fun provideMainPresenter() = MainPresenter()


    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}