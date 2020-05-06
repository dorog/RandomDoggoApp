package bme.hu.randomdoggo.database.repository

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import bme.hu.randomdoggo.database.dao.RandomDoggoDao
import bme.hu.randomdoggo.model.RandomDoggo

class RandomDoggoRoomRepository(private val randomDoggoDao: RandomDoggoDao) : RandomDoggoRepository{

    private val allRandomDoggo: LiveData<List<RandomDoggo>> = randomDoggoDao.getAll()

    @WorkerThread
    override fun addRandomDoggo(randomDoggo: RandomDoggo) {
        Log.d("REPO", "" + randomDoggo.fileSizeBytes)
        randomDoggoDao.insert(randomDoggo)
    }

    @WorkerThread
    override fun removeRandomDoggo(randomDoggo: RandomDoggo) {
        randomDoggoDao.delete(randomDoggo)
    }

    override fun getAllRandomDoggo(): LiveData<List<RandomDoggo>> {
        return allRandomDoggo
    }
}