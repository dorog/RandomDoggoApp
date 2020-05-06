package bme.hu.randomdoggo.ui.favourites

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.viewmodel.RandomDoggoViewModel
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import javax.inject.Inject

class FavouritesFragment : Fragment(), FavouritesScreen {

    @Inject
    lateinit var favouritesPresenter: FavouritesPresenter;

    private lateinit var randomDoggoViewModel: RandomDoggoViewModel

    private val adapter by lazy { FavouritesAdapter() }
    private val manager by lazy { LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) }
    private var doggosRecyclerView: RecyclerView? = null
    private var randomDoggos : List<RandomDoggo> = listOf()

    private var swipeBackground: ColorDrawable = ColorDrawable(Color.parseColor("#FF0000"))
    private lateinit var deleteIconWhite: Drawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_favourites, container, false)
        doggosRecyclerView = view.findViewById(R.id.doggo_list)

        if (doggosRecyclerView is RecyclerView) {
            doggosRecyclerView?.setHasFixedSize(true)
            doggosRecyclerView?.layoutManager = manager
            doggosRecyclerView?.adapter = adapter
        }

        deleteIconWhite = ContextCompat.getDrawable(view.context, R.drawable.ic_delete_white_24dp)!!

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val randomDoggo = adapter.removeItem(viewHolder)
                removeRandomDoggoFromDatabase(randomDoggo)
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                val itemView = viewHolder.itemView

                val iconMargin = (itemView.height - deleteIconWhite.intrinsicHeight) / 2

                swipeBackground.setBounds(itemView.left, itemView.top, dX.toInt(), itemView.bottom)
                swipeBackground.draw(c)

                deleteIconWhite.setBounds(itemView.left + iconMargin, itemView.top + iconMargin,
                        itemView.left + iconMargin + deleteIconWhite.intrinsicWidth, itemView.bottom - iconMargin)
                deleteIconWhite.draw(c)

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(doggosRecyclerView)

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

    override fun removeRandomDoggoFromDatabase(randomDoggo: RandomDoggo) {
        randomDoggoViewModel.delete(randomDoggo)
        DynamicToast.make(activity!!, "Successfully deleted!", deleteIconWhite).show();
    }
}
