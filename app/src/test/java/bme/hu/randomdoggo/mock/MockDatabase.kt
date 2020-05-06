package bme.hu.randomdoggo.mock

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import bme.hu.randomdoggo.database.RandomDoggoRoomDatabase
import bme.hu.randomdoggo.database.repository.RandomDoggoMockRepository
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository

class MockDatabase : RandomDoggoRoomDatabase() {

    private var randomDoggoMockRepository = RandomDoggoMockRepository()

    override fun randomDoggoRepository(): RandomDoggoRepository {
        return randomDoggoMockRepository
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAllTables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}