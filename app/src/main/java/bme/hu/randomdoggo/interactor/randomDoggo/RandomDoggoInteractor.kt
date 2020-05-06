package bme.hu.randomdoggo.interactor.randomDoggo

import android.util.Log
import bme.hu.randomdoggo.interactor.randomDoggo.event.GetRandomDoggoEvent
import bme.hu.randomdoggo.network.NetworkInteractor
import bme.hu.randomdoggo.network.RandomDoggoApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class RandomDoggoInteractor @Inject constructor(private var randomDoggoApi: RandomDoggoApi) : NetworkInteractor {

    override fun getRandomDoggoFromWeb() {
        val event = GetRandomDoggoEvent()

        try {

            val jokeCall = randomDoggoApi.getRandomDoggo()

            val response = jokeCall.execute()

            event.randomDoggo = response.body()
            event.code = response.code()

            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            EventBus.getDefault().post(event)
        }
    }
}