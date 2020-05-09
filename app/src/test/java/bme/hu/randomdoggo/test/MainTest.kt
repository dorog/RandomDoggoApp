package bme.hu.randomdoggo.test

import bme.hu.randomdoggo.testInjector
import bme.hu.randomdoggo.ui.main.MainPresenter
import bme.hu.randomdoggo.ui.main.MainScreen
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainTest {

    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun showSearchTest(){
        mainPresenter.showSearch()
        verify(mainScreen).showSearch()
    }

    @Test
    fun showFavouritesTest(){
        mainPresenter.showFavourites()
        verify(mainScreen).showFavourites()
    }

    @Test
    fun showCreditsTest(){
        mainPresenter.showCredits()
        verify(mainScreen).showCredits()
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}