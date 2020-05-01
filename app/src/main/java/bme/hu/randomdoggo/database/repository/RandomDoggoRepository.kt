package bme.hu.randomdoggo.database.repository

import androidx.lifecycle.LiveData
import bme.hu.randomdoggo.model.RandomDoggo

interface RandomDoggoRepository {
    fun addRandomDoggo(randomDoggo: RandomDoggo)
    fun removeRandomDoggo(randomDoggo: RandomDoggo)
    fun getAllRandomDoggo() : LiveData<List<RandomDoggo>>
}