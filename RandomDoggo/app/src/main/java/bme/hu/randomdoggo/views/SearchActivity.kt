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
        TODO("Missing") //Get a Random Doggo from SearchPresenter and Show it (UI)
    }

    override fun addRandomDoggoToFavourites(randomDoggo: RandomDoggo) {
        TODO("Missing") //Save the Random Doggo with SearchPresenter (database) and UI update
    }

    fun navigateToFavourites(){
        searchPresenter.navigate(this, FavouritesActivity::class.java)
    }
}
