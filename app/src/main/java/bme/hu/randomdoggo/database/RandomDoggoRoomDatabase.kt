package bme.hu.randomdoggo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.model.RandomDoggo

@Database(entities = arrayOf(RandomDoggo::class), version = 1)
abstract class RandomDoggoRoomDatabase: RoomDatabase() {
    abstract fun randomDoggoRepository(): RandomDoggoRepository
}