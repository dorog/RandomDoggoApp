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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun showDetailsFragment(){

    }

    fun hideDetailsFragment(){

    }

    fun navigateToSearchActivity(){
        favouritesPresenter.navigate(this, SearchActivity::class.java)
    }
}
