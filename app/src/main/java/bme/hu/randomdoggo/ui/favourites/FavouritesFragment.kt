package bme.hu.randomdoggo.ui.favourites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import javax.inject.Inject

class FavouritesFragment : Fragment(), FavouritesScreen {

    @Inject
    lateinit var favouritesPresenter: FavouritesPresenter;

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        favouritesPresenter.attachScreen(this)
    }

    override fun onDetach() {
        favouritesPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
