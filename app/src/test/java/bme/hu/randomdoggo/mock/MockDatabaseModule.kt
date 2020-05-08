package bme.hu.randomdoggo.mock

import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDatabaseModule {

    @Provides
    @Singleton
    fun provideRandomDoggoRepository(): RandomDoggoRepository = MockRepository()
}