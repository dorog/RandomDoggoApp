package bme.hu.randomdoggo.ui.details

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bme.hu.randomdoggo.R

private const val id_const = "id"
private const val url_const = "url"
private const val byte_const = "byte"
private const val type_const = "type"

class DetailsFragment : Fragment(), DetailsScreen {

    private var id: Int? = null
    private var url: String? = null
    private var byte: String? = null
    private var type: String? = null

    private lateinit var detailsScreen: DetailsPresenter;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        detailsScreen.attachScreen(this)
    }

    override fun onDetach() {
        detailsScreen.detachScreen()
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(id_const)
            url = it.getString(url_const)
            byte = it.getString(byte_const)
            type = it.getString(type_const)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int, url: String, byte: String, type: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(id_const, id)
                    putString(url_const, url)
                    putString(byte_const, byte)
                    putString(type_const, type)
                }
            }
    }

    override fun removeRandomDoggo() {
        TODO("missing") //Remove the Random Doggo with DetailsScreen's function (from database)
    }
}
