package bme.hu.randomdoggo.mock

import bme.hu.randomdoggo.network.NetworkConfig
import bme.hu.randomdoggo.network.RandomDoggoApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    @Provides
    @Singleton
    fun provideRandomDoggoApi(client: OkHttpClient): RandomDoggoApi = MockRandomDoggoApi()
}