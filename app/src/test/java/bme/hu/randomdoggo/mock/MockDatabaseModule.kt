package bme.hu.randomdoggo.mock

import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class MockDatabaseModule {

    @Provides
    @Singleton
    fun provideRandomDoggoRepository(): RandomDoggoRepository = MockRepository()

    @Provides
    @Singleton
    fun provideScope(): CoroutineScope {
        val parentJob = Job();
        val coroutineContext: CoroutineContext = parentJob + Dispatchers.Main
        val scope = CoroutineScope(coroutineContext)

        return scope
    }
}