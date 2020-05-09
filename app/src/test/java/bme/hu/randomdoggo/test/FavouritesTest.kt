package bme.hu.randomdoggo.test

import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.testInjector
import bme.hu.randomdoggo.ui.favourites.FavouritesPresenter
import bme.hu.randomdoggo.ui.favourites.FavouritesScreen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject
import com.nhaarman.mockito_kotlin.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class FavouritesTest{

    @Inject
    lateinit var favouritesPresenter: FavouritesPresenter
    private lateinit var favouritesScreen: FavouritesScreen

    @Inject
    lateinit var mockRepository: RandomDoggoRepository
    private var randomDoggo = RandomDoggo(-1, "https://random.dog/1400de7f-00a2-4ddd-b40f-1c9040105401.JPG", 1234, null)


    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        favouritesScreen = mock()
        favouritesPresenter.attachScreen(favouritesScreen)

        mockRepository.addRandomDoggo(randomDoggo)
    }

    @Test
    fun getRandomDoggosTest(){
        val list = favouritesPresenter.getRandomDoggos()
        val size = list.value?.size
        assert(size == 1)
    }


    @Test
    fun removeRandomDoggoTest(){
        runBlocking {
            favouritesPresenter.removeRandomDoggoFromDatabase(randomDoggo)
        }

        val size = mockRepository.getAllRandomDoggo().value?.size
        assert(size == 0)
    }

    @After
    fun tearDown() {
        favouritesPresenter.detachScreen()
        mockRepository.deleteAll()
    }
}