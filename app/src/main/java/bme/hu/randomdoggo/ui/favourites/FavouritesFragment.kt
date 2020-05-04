package bme.hu.randomdoggo.ui.favourites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import kotlinx.android.synthetic.main.fragment_favourites.*
import java.util.*
import javax.inject.Inject

class FavouritesFragment : Fragment(), FavouritesScreen {

    @Inject
    lateinit var favouritesPresenter: FavouritesPresenter;

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
    }

    override fun onStart() {
        super.onStart()
        favouritesPresenter.attachScreen(this)
        showFavourites()
    }

    override fun onStop() {
        super.onStop()
        favouritesPresenter.detachScreen()
    }

    override fun showFavourites() {
        //Toast.makeText(context, "Out of jokes! :( ", Toast.LENGTH_LONG).show()
        val one = RandomDoggo(null, "http://asd.hu", 10, null)
        val two = RandomDoggo(null, "http://asd.com", 10, null)
        val randomDoggos = listOf(one, two)

        adapter.addDoggos(randomDoggos)
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
