package bme.hu.randomdoggo.ui.favourites

import androidx.lifecycle.LiveData
import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.ui.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class FavouritesPresenter @Inject constructor(private var randomDoggoRepository: RandomDoggoRepository, private var scope: CoroutineScope): Presenter<FavouritesScreen>() {

    /*private var parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)*/

    fun removeRandomDoggoFromDatabase(randomDoggo: RandomDoggo) = scope.launch(Dispatchers.IO){
        randomDoggoRepository.removeRandomDoggo(randomDoggo)
    }

    fun getRandomDoggos(): LiveData<List<RandomDoggo>>{
        return randomDoggoRepository.getAllRandomDoggo()
    }
}