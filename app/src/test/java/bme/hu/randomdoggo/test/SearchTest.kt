package bme.hu.randomdoggo.test

import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.mock.MockRandomDoggoApi
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.testInjector
import bme.hu.randomdoggo.ui.search.SearchPresenter
import bme.hu.randomdoggo.ui.search.SearchScreen
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class SearchTest{

    @Inject
    lateinit var searchPresenter: SearchPresenter

    @Inject
    lateinit var mockRepository: RandomDoggoRepository
    private var randomDoggo = RandomDoggo(-1, "http://mock/mock.jpg", 1234, null)
    private var randomDoggo2 = RandomDoggo(0, "http://mock/mock.jpg", 1234, null)

    private lateinit var searchScreen: SearchScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        searchScreen = mock()
        searchPresenter.attachScreen(searchScreen)

        mockRepository.addRandomDoggo(randomDoggo)
    }

    @Test
    fun searchTest(){
        searchPresenter.searchRandomDoggo()
        verify(searchScreen).showRandomDoggo(MockRandomDoggoApi.randomDoggo)
    }

    @Test
    fun addToDatabaseTest(){
        runBlockingTest {
            searchPresenter.addRandomDoggoToDatabase(randomDoggo2)
        }

        val size = mockRepository.getAllRandomDoggo().value?.size
        assert(size == 2)
    }

    @After
    fun tearDown() {
        searchPresenter.detachScreen()
        mockRepository.deleteAll()
    }
}