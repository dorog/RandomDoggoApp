package bme.hu.randomdoggo.mock

import android.content.Context
import bme.hu.randomdoggo.database.RandomDoggoRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDatabaseModule {
    @Provides
    @Singleton
    fun getDatabase(context: Context): RandomDoggoRoomDatabase = MockDatabase()
}