package bme.hu.randomdoggo.ui.favourites

import androidx.lifecycle.LiveData
import bme.hu.randomdoggo.database.RandomDoggoRoomDatabase
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.ui.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class FavouritesPresenter @Inject constructor(randomDoggoRoomDatabase: RandomDoggoRoomDatabase): Presenter<FavouritesScreen>() {

    private var randomDoggoRoomRepository: RandomDoggoRepository
    private val randomDoggos: LiveData<List<RandomDoggo>>

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init{
        randomDoggoRoomRepository = randomDoggoRoomDatabase.randomDoggoRepository()
        randomDoggos = randomDoggoRoomRepository.getAllRandomDoggo()
    }

    fun removeRandomDoggoFromDatabase(randomDoggo: RandomDoggo)= scope.launch(Dispatchers.IO){
        randomDoggoRoomRepository.removeRandomDoggo(randomDoggo)
    }

    fun getRandomDoggos(): LiveData<List<RandomDoggo>>{
        return randomDoggos
    }
}