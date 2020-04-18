package bme.hu.randomdoggo.network

import bme.hu.randomdoggo.model.RandomDoggo
import retrofit2.Call
import retrofit2.http.GET

interface RandomDoggoApi {
    @GET
    fun getRandomDoggo(): Call<RandomDoggo>
}