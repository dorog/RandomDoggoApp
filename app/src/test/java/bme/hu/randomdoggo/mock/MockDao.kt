package bme.hu.randomdoggo.mock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import bme.hu.randomdoggo.database.dao.RandomDoggoDao
import bme.hu.randomdoggo.model.RandomDoggo

class MockDao : RandomDoggoDao {

    private var database: MutableLiveData<List<RandomDoggo>> = MutableLiveData()

    override fun getAll(): LiveData<List<RandomDoggo>> {
        return database
    }

    override fun insert(randomdoggo: RandomDoggo) {
        randomdoggo.id = lastId
        lastId++


        val list = mutableListOf<RandomDoggo>();
        list.addAll(database.value!!)
        list.add(randomdoggo)

        database.postValue(list)
    }

    override fun delete(randomdoggo: RandomDoggo) {
        val list = mutableListOf<RandomDoggo>();
        list.remove(randomdoggo)
        database.postValue(list)
    }

    companion object {
        private var lastId: Int = 0
    }
}