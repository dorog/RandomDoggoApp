package bme.hu.randomdoggo.mock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.model.RandomDoggo

class MockRepository : RandomDoggoRepository {

    private var database: MutableLiveData<List<RandomDoggo>> = MutableLiveData()

    init {
        val list = listOf<RandomDoggo>()
        database = MutableLiveData(list)
    }

    override fun addRandomDoggo(randomDoggo: RandomDoggo) {
        randomDoggo.id = lastId
        lastId++

        val list = mutableListOf<RandomDoggo>();
        list.addAll(database.value!!)
        list.add(randomDoggo)

        database = MutableLiveData(list)
    }

    override fun removeRandomDoggo(randomDoggo: RandomDoggo) {
        val list = mutableListOf<RandomDoggo>();
        list.addAll(database.value!!)
        list.remove(randomDoggo)
        database = MutableLiveData(list)
    }

    override fun getAllRandomDoggo(): LiveData<List<RandomDoggo>> {
        return database
    }

    companion object {
        private var lastId: Int = 0
    }
}