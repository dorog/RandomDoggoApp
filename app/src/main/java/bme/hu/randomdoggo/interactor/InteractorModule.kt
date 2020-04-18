package bme.hu.randomdoggo.interactor

import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.network.RandomDoggoApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideRandomDoggoInteractor(randomDoggoApi: RandomDoggoApi) = RandomDoggoInteractor(randomDoggoApi)
}