package bme.hu.randomdoggo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import bme.hu.randomdoggo.database.dao.RandomDoggoDao
import bme.hu.randomdoggo.model.RandomDoggo

@Database(entities = arrayOf(RandomDoggo::class), version = 1)
abstract class RandomDoggoRoomDatabase: RoomDatabase() {
    abstract fun randomDoggoDao(): RandomDoggoDao

    companion object {
        @Volatile
        private var INSTANCE: RandomDoggoRoomDatabase? = null

        fun getDatabase(context: Context) : RandomDoggoRoomDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RandomDoggoRoomDatabase::class.java,
                    "randomDoggo_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}