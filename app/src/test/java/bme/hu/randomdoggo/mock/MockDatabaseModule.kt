package bme.hu.randomdoggo.mock

import bme.hu.randomdoggo.database.dao.RandomDoggoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDatabaseModule {

    @Provides
    @Singleton
    fun provideRandomDoggoDao(): RandomDoggoDao = MockDao()
}