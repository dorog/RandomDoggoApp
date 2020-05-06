package bme.hu.randomdoggo.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.viewmodel.RandomDoggoViewModel
import com.bumptech.glide.Glide
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.fragment_search.view.*
import javax.inject.Inject

class SearchFragment : Fragment(), SearchScreen {

    @Inject
    lateinit var searchPresenter: SearchPresenter
    private lateinit var randomDoggoViewModel: RandomDoggoViewModel

    private lateinit var randomDoggoPicture: ImageView
    private lateinit var addToFavouritesButton: Button
    private lateinit var searchButton: Button

    private var currentRandomDoggo: RandomDoggo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        addToFavouritesButton = view.add_to_favourites
        addToFavouritesButton.setOnClickListener{ _ ->
            searchPresenter.addRandomDoggoToDatabase()
            DynamicToast.makeSuccess(context!!, "Successfully added!").show();
        }

        addToFavouritesButton.isEnabled = false

        searchButton = view.search_randomDoggo
        searchButton.setOnClickListener{ _ ->
            searchRandomDoggo()
        }

        randomDoggoPicture = view.search_imageView

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
        searchButton.isEnabled = false
        searchPresenter.searchRandomDoggo()
    }

    override fun showRandomDoggo(randomDoggo: RandomDoggo) {
        Glide.with(this)
                .load(randomDoggo.url)
                .into(randomDoggoPicture)
        currentRandomDoggo = randomDoggo
        currentRandomDoggo!!.type = getType(randomDoggo)

        if(currentRandomDoggo != null && !addToFavouritesButton.isEnabled){
            addToFavouritesButton.isEnabled = true
        }
        searchButton.isEnabled = true
    }

    override fun addRandomDoggoToFavourites() {
        randomDoggoViewModel.insert(currentRandomDoggo!!)
        addToFavouritesButton.isEnabled = false
    }

    private fun getType(randomDoggo: RandomDoggo): String{
        return randomDoggo.url.substringAfterLast(".")
    }
}
