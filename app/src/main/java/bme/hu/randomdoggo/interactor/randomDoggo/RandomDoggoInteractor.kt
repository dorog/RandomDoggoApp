package bme.hu.randomdoggo.interactor.randomDoggo

import bme.hu.randomdoggo.network.RandomDoggoApi
import javax.inject.Inject

class RandomDoggoInteractor @Inject constructor(private var randomDoggoApi: RandomDoggoApi) {

    fun getRandomDoggoFromWeb() {}
}