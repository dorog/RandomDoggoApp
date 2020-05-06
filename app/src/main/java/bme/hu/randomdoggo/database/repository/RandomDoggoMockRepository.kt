package bme.hu.randomdoggo.database.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bme.hu.randomdoggo.model.RandomDoggo

class RandomDoggoMockRepository : RandomDoggoRepository {

    private var database: MutableLiveData<List<RandomDoggo>> = MutableLiveData()

    override fun addRandomDoggo(randomDoggo: RandomDoggo) {
        randomDoggo.id = lastId
        lastId++


        val list = mutableListOf<RandomDoggo>();
        list.addAll(database.value!!)
        list.add(randomDoggo)

        database.postValue(list)
    }

    override fun removeRandomDoggo(randomDoggo: RandomDoggo) {
        val list = mutableListOf<RandomDoggo>();
        list.remove(randomDoggo)
        database.postValue(list)
    }

    override fun getAllRandomDoggo(): LiveData<List<RandomDoggo>> {
        return database
    }

    companion object {
        private var lastId: Int = 0
    }
}