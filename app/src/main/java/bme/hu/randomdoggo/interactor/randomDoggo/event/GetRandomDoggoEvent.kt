package bme.hu.randomdoggo.interactor.randomDoggo.event

import bme.hu.randomdoggo.model.RandomDoggo

data class GetRandomDoggoEvent(
    var code: Int = 0,
    var randomDoggo: RandomDoggo? = null,
    var throwable: Throwable? = null
)