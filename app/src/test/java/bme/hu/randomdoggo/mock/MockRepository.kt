package bme.hu.randomdoggo.mock

import android.util.Log
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
        Log.d("ADD", "Before" + database.value!!.size)
        randomDoggo.id = lastId
        lastId++

        val list = mutableListOf<RandomDoggo>();
        list.addAll(database.value!!)
        list.add(randomDoggo)

        database = MutableLiveData(list)
        Log.d("ADD", "AFTER" + database.value!!.size)
    }

    override fun removeRandomDoggo(randomDoggo: RandomDoggo) {
        Log.d("REMOVE Repo", "Before: " + database.value!!.size)
        val list = mutableListOf<RandomDoggo>()
        list.addAll(database.value!!)
        list.remove(randomDoggo)
        database = MutableLiveData(list)
        Log.d("REMOVE Repo", "After: " + database.value!!.size)
    }

    override fun getAllRandomDoggo(): LiveData<List<RandomDoggo>> {
        return database
    }

    override fun deleteAll(){
        val list = mutableListOf<RandomDoggo>()
        Log.d("MOCK", "Before" + database.value!!.size)
        database = MutableLiveData(list)
        Log.d("MOCK", "After" + database.value!!.size)
    }

    companion object {
        private var lastId: Int = 0
    }
}