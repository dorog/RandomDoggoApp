package bme.hu.randomdoggo.ui.favourites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.viewmodel.RandomDoggoViewModel
import javax.inject.Inject
import androidx.lifecycle.Observer

class FavouritesFragment : Fragment(), FavouritesScreen {

    @Inject
    lateinit var favouritesPresenter: FavouritesPresenter;

    private lateinit var randomDoggoViewModel: RandomDoggoViewModel

    private val adapter by lazy { FavouritesAdapter() }
    private val manager by lazy { LinearLayoutManager(context) }
    private var doggo_list: RecyclerView? = null
    private var randomDoggos : List<RandomDoggo> = listOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_favourites, container, false)
        doggo_list = view.findViewById(R.id.doggo_list)

        if (doggo_list is RecyclerView) {
            doggo_list?.layoutManager = manager
            doggo_list?.adapter = adapter
        }

        return view
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
        randomDoggoViewModel = ViewModelProviders.of(this).get(RandomDoggoViewModel::class.java)
        randomDoggoViewModel.randomDoggos.observe(this, Observer { savedRandomDoggos: List<RandomDoggo> ->
            randomDoggos = savedRandomDoggos
            showFavourites()
        })
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
        adapter.refresh(randomDoggos)
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
