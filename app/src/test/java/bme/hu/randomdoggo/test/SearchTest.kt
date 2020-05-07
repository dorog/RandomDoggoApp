package bme.hu.randomdoggo.test

import bme.hu.randomdoggo.database.dao.RandomDoggoDao
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.network.RandomDoggoApi
import bme.hu.randomdoggo.testInjector
import bme.hu.randomdoggo.ui.search.SearchPresenter
import bme.hu.randomdoggo.ui.search.SearchScreen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class SearchTest{

    @Inject
    lateinit var searchPresenter: SearchPresenter

    @Inject
    lateinit var mockApi: RandomDoggoApi

    @Inject
    lateinit var mockDao: RandomDoggoDao
    private var randomDoggoDao = RandomDoggo(-1, "http://mock/mockDao.jpg", 1234, null)

    private lateinit var searchScreen: SearchScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        //searchPresenter = mock()
        searchPresenter.attachScreen(searchScreen)
    }

    @Test
    fun addToDatabaseTest(){

    }

    @Test
    fun searchTest(){
        searchPresenter.searchRandomDoggo()

    }

    @After
    fun tearDown() {
        searchPresenter.detachScreen()
    }
}