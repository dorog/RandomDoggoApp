package bme.hu.randomdoggo.ui.favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.ui.details.DetailsEvent
import com.bumptech.glide.Glide
import org.greenrobot.eventbus.EventBus

class FavouritesAdapter(private val doggoList: MutableList<RandomDoggo> = mutableListOf()) : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

    private var byteFormat: String = "%02d byte"

    fun refresh(doggos: List<RandomDoggo>){
        doggoList.clear()
        doggoList.addAll(doggos)
        notifyDataSetChanged()
    }

    fun removeItem(viewHolder: RecyclerView.ViewHolder): RandomDoggo{
        val randomDoggo = doggoList[viewHolder.absoluteAdapterPosition]
        doggoList.removeAt(viewHolder.absoluteAdapterPosition)
        notifyDataSetChanged()

        return randomDoggo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.doggo_item, parent, false)
        return FavouritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val currentItem = doggoList[position]

        holder.typeText.text = currentItem.type
        holder.byteText.text = String.format(byteFormat, currentItem.fileSizeBytes)
        Glide.with(holder.pictureImage)
                .load(currentItem.url)
                .into(holder.pictureImage)

        holder.pictureImage.setOnClickListener{
            val detailsEvent = DetailsEvent()
            detailsEvent.randomDoggo = RandomDoggo(currentItem.id, currentItem.url, currentItem.fileSizeBytes, currentItem.type)

            EventBus.getDefault().post(detailsEvent)
        }
    }

    override fun getItemCount() = doggoList.size

    class FavouritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pictureImage: ImageView = itemView.findViewById(R.id.picture)
        var typeText: TextView = itemView.findViewById(R.id.type)
        var byteText: TextView = itemView.findViewById(R.id.fileSizeBytes)
    }
}