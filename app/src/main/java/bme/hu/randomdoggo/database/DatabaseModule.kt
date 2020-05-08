package bme.hu.randomdoggo.database

import android.content.Context
import androidx.room.Room
import bme.hu.randomdoggo.database.dao.RandomDoggoDao
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.database.repository.RandomDoggoRoomRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Provides
    @Singleton
    fun getDatabase(context: Context): RandomDoggoRoomDatabase = Room.databaseBuilder(context.applicationContext,
            RandomDoggoRoomDatabase::class.java,
            "randomDoggo_database")
            .build()

    @Provides
    @Singleton
    fun provideRandomDoggoDao(context: Context): RandomDoggoDao = getDatabase(context).randomDoggoDao()

    @Provides
    @Singleton
    fun provideRandomDoggoRepository(randomDoggoDao: RandomDoggoDao): RandomDoggoRepository = RandomDoggoRoomRepository(randomDoggoDao)
}