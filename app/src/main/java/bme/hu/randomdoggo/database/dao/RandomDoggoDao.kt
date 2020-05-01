package bme.hu.randomdoggo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import bme.hu.randomdoggo.model.RandomDoggo

@Dao
interface RandomDoggoDao {

    @Query("SELECT * FROM randomdoggo")
    fun getAll(): LiveData<List<RandomDoggo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(randomdoggo: RandomDoggo)

    @Delete
    fun delete(randomdoggo: RandomDoggo)
}