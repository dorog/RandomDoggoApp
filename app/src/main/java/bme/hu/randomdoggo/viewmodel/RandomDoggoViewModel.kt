package bme.hu.randomdoggo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import bme.hu.randomdoggo.database.RandomDoggoRoomDatabase
import bme.hu.randomdoggo.database.repository.RandomDoggoRoomRepository
import bme.hu.randomdoggo.model.RandomDoggo
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RandomDoggoViewModel(application: Application): AndroidViewModel(application) {

    private val repository: RandomDoggoRoomRepository
    val randomDoggos: LiveData<List<RandomDoggo>>

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        val randomDoggoDao = RandomDoggoRoomDatabase.getDatabase(application).randomDoggoDao()
        repository = RandomDoggoRoomRepository(randomDoggoDao)
        randomDoggos = repository.getAllRandomDoggo()
    }

    fun insert(randomDoggo: RandomDoggo) = scope.launch(Dispatchers.IO){
        repository.addRandomDoggo(randomDoggo)
    }

    fun delete(randomDoggo: RandomDoggo){
        repository.removeRandomDoggo(randomDoggo)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}