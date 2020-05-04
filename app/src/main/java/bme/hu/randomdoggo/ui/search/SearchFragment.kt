package bme.hu.randomdoggo.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import javax.inject.Inject

class SearchFragment : Fragment(), SearchScreen {

    @Inject
    lateinit var searchPresenter: SearchPresenter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        searchPresenter.attachScreen(this)
    }

    override fun onDetach() {
        searchPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        TODO("Missing") //Start the Favourites Activity
    }
}
