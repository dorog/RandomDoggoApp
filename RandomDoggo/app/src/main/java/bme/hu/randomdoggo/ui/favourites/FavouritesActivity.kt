package bme.hu.randomdoggo.ui.favourites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.ui.search.SearchActivity

class FavouritesActivity : AppCompatActivity(),
    FavouritesScreen {

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
        TODO("missing") //Start the Search Activity
    }
}
