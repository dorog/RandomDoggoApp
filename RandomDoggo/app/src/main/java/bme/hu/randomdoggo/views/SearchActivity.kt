package bme.hu.randomdoggo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.models.RandomDoggo
import bme.hu.randomdoggo.presenters.SearchPresenter
import bme.hu.randomdoggo.views.interfaces.SearchScreen

class SearchActivity : AppCompatActivity(), SearchScreen {

    private lateinit var searchPresenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_screen)
    }

    override fun onStart() {
        super.onStart()
        searchPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        searchPresenter.detachScreen()
    }

    override fun searchRandomDoggo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addRandomDoggoToFavourites(randomDoggo: RandomDoggo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun navigateToFavourites(){
        searchPresenter.navigate(this, FavouritesActivity::class.java)
    }
}
