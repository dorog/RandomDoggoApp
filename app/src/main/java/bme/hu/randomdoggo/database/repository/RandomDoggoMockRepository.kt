package bme.hu.randomdoggo.database.repository

import androidx.lifecycle.LiveData
import bme.hu.randomdoggo.model.RandomDoggo

class RandomDoggoMockRepository : RandomDoggoRepository {

    private var database: MutableCollection<RandomDoggo> = mutableListOf()

    override fun addRandomDoggo(randomDoggo: RandomDoggo) {
        randomDoggo.id = lastId
        lastId++
        database.add(randomDoggo)
    }

    override fun removeRandomDoggo(randomDoggo: RandomDoggo) {
        database.remove(randomDoggo)
    }

    override fun getAllRandomDoggo(): LiveData<List<RandomDoggo>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private var lastId: Int = 0
    }
}