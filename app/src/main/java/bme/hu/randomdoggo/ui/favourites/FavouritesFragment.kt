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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import javax.inject.Inject

class FavouritesFragment : Fragment(), FavouritesScreen {

    @Inject
    lateinit var favouritesPresenter: FavouritesPresenter;

    private val adapter by lazy { FavouritesAdapter() }
    private val manager by lazy { LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) }
    private var doggosRecyclerView: RecyclerView? = null
    private var randomDoggos : List<RandomDoggo> = listOf()

    private var swipeBackground: ColorDrawable = ColorDrawable(Color.parseColor("#000000"))
    private lateinit var deleteIconWhite: Drawable

    private var successFullyDeletedMessage: String = "Successfully deleted!"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_favourites, container, false)

        doggosRecyclerView = view.findViewById(R.id.doggo_list)
        setupRecyclerView(doggosRecyclerView!!)

        setupSwipeDelete(view)

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
        favouritesPresenter.getRandomDoggos().observe(this, Observer { savedRandomDoggos: List<RandomDoggo> ->
            randomDoggos = savedRandomDoggos
            showFavourites()
        })
    }

    override fun showFavourites() {
        adapter.refresh(randomDoggos)
    }

    override fun removeRandomDoggoFromDatabase(randomDoggo: RandomDoggo) {
        favouritesPresenter.removeRandomDoggoFromDatabase(randomDoggo)
        randomDoggos = randomDoggos.filter { x -> x != randomDoggo }
        DynamicToast.make(activity!!, successFullyDeletedMessage, deleteIconWhite).show();
    }

    private fun setupRecyclerView(doggosRecyclerView: RecyclerView){
        doggosRecyclerView.setHasFixedSize(true)
        doggosRecyclerView.layoutManager = manager
        doggosRecyclerView.adapter = adapter
    }

    private fun setupSwipeDelete(view: View) {
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
    }
}
