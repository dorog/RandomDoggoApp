package bme.hu.randomdoggo.network

import bme.hu.randomdoggo.interactor.randomDoggo.event.GetRandomDoggoEvent
import bme.hu.randomdoggo.model.RandomDoggo
import org.greenrobot.eventbus.EventBus

class MockNetworkInteractor : NetworkInteractor {

    override fun getRandomDoggoFromWeb() {
        val randomDoggo = RandomDoggo(null, "https://random.dog/713ae190-d34f-4355-a9c3-abbdc642a105.jpg", 12345, null)

        val event = GetRandomDoggoEvent()
        event.code = 200
        event.randomDoggo = randomDoggo

        EventBus.getDefault().post(event)
    }
}