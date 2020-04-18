package bme.hu.randomdoggo.interactor.randomDoggo

import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.network.RandomDoggoApi
import javax.inject.Inject

class RandomDoggoInteractor @Inject constructor(private var randomDoggoApi: RandomDoggoApi) {

    fun getRandomDoggoFromWeb() {}

    fun addToDatabase(randomDoggo: RandomDoggo) {}

    fun getAllFromDatabase() {}

    fun deleteFromDatabase(id: Int) {}
}