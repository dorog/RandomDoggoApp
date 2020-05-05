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
import bme.hu.randomdoggo.interactor.randomDoggo.event.GetRandomDoggoEvent
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.viewmodel.RandomDoggoViewModel
import kotlinx.android.synthetic.main.fragment_search.view.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
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

        view.search_randomDoggo.setOnClickListener{ _ ->
            searchRandomDoggo()
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

    override fun onStop() {
        super.onStop()
        searchPresenter.detachScreen()
    }

    override fun searchRandomDoggo() {
        searchPresenter.searchRandomDoggo()
    }

    override fun showRandomDoggo(randomDoggo: RandomDoggo) {
        Toast.makeText(context, "Successfully arrived!", Toast.LENGTH_LONG).show()
    }

    override fun addRandomDoggoToFavourites(randomDoggo: RandomDoggo) {
        randomDoggoViewModel.insert(randomDoggo)
    }
}
