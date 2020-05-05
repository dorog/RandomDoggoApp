package bme.hu.randomdoggo.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.viewmodel.RandomDoggoViewModel
import kotlinx.android.synthetic.main.fragment_search.view.*
import javax.inject.Inject

class SearchFragment : Fragment(), SearchScreen {

    @Inject
    lateinit var searchPresenter: SearchPresenter
    private lateinit var randomDoggoViewModel: RandomDoggoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        view.add_to_favourites.setOnClickListener{ _ ->
            val randomDoggo2 = RandomDoggo(null, "abc", 0, null);
            addRandomDoggoToFavourites(randomDoggo2)
            Toast.makeText(context, "Successfully added!", Toast.LENGTH_LONG).show()
        }

        return view
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
        randomDoggoViewModel = ViewModelProviders.of(this).get(RandomDoggoViewModel::class.java)
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
        randomDoggoViewModel.insert(randomDoggo)
    }

    fun navigateToFavourites(){
        TODO("Missing") //Start the Favourites Activity
    }
}
