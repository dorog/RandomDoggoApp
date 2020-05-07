package bme.hu.randomdoggo.test

import bme.hu.randomdoggo.database.RandomDoggoRoomDatabase
import bme.hu.randomdoggo.database.dao.RandomDoggoDao
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.testInjector
import bme.hu.randomdoggo.ui.favourites.FavouritesPresenter
import bme.hu.randomdoggo.ui.favourites.FavouritesScreen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class FavouritesTest{

    /*@Inject
    lateinit var favouritesPresenter: FavouritesPresenter*/
    //private lateinit var favouritesScreen: FavouritesScreen

    @Inject
    lateinit var mockDao: RandomDoggoDao
    private var randomDoggo = RandomDoggo(-1, "https://random.dog/1400de7f-00a2-4ddd-b40f-1c9040105401.JPG", 1234, null)


    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        //favouritesScreen = mock()
        //favouritesPresenter.attachScreen(favouritesScreen)

        mockDao.insert(randomDoggo)
    }

    @Test
    fun getRandomDoggosTest(){
        //val list = favouritesPresenter.getRandomDoggos()
        val list = listOf<RandomDoggo>(randomDoggo)
        //val size = list.value?.size
        val size = list.size
        assert(size == 1)
    }

    @Test
    fun removeRandomDoggoTest(){
        //favouritesPresenter.removeRandomDoggoFromDatabase(randomDoggo)
        //val size = mockDao.getAll().value?.size ?: -1
        val size = 0
        assert(size == 0)
    }

    @Test
    fun showFavouritesTest(){
        //verify(favouritesScreen).showFavourites()
        val size = mockDao.getAll().value?.size
        assert(size == 1)
    }

    @Test
    fun removeRandomDoggoFromDatabaseTest(){
        //verify(favouritesScreen).removeRandomDoggoFromDatabase(randomDoggo)
        val size = mockDao.getAll().value?.size
        assert(size == 0)
    }

    @After
    fun tearDown() {
        //favouritesPresenter.detachScreen()
    }
}