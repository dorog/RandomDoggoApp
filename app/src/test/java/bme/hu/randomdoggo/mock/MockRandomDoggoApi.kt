package bme.hu.randomdoggo.mock

import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.network.RandomDoggoApi
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockRandomDoggoApi : RandomDoggoApi{

    override fun getRandomDoggo(): Call<RandomDoggo> {
        val randomDoggo = RandomDoggo(null, "https://random.dog/6d7c676e-e48d-4e53-9f4d-46561ce429c1.JPG", 50, null)

        val call = object : Call<RandomDoggo> {
            override fun enqueue(callback: Callback<RandomDoggo>?) {
            }

            @Throws(IOException::class)
            override fun execute(): Response<RandomDoggo> {
                return Response.success(randomDoggo)
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<RandomDoggo> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        return call
    }
}