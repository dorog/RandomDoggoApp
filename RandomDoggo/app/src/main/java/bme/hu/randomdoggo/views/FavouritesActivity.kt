package bme.hu.randomdoggo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.presenters.FavouritesPresenter
import bme.hu.randomdoggo.views.interfaces.FavouritesScreen

class FavouritesActivity : AppCompatActivity(), FavouritesScreen {

    private lateinit var favouritesPresenter: FavouritesPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites_screen)
    }

    override fun onStart() {
        super.onStart()
        favouritesPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        favouritesPresenter.detachScreen()
    }

    override fun showFavourites() {
        TODO("missing") //Get the favourites Random Doggo(s) and init the UI
    }

    fun showDetailsFragment(){
        TODO("missing") //Show the Details Fragment and add the Random Doggo to it
    }

    fun hideDetailsFragment(){
        TODO("missing") //Hide the details Fragment and show the favourites list again
    }

    fun navigateToSearchActivity(){
        favouritesPresenter.navigate(this, SearchActivity::class.java)
    }
}
