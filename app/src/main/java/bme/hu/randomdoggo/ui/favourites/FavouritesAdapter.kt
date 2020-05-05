package bme.hu.randomdoggo.ui.favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.model.RandomDoggo

class FavouritesAdapter(private val doggoList: MutableList<RandomDoggo> = mutableListOf()) : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

    fun refresh(doggos: List<RandomDoggo>){
        doggoList.clear()
        doggoList.addAll(doggos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.doggo_item, parent, false)

        return FavouritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val currentItem = doggoList[position]

        //holder.imageView.setImageResource(currentItem.url)
        holder.textView.text = currentItem.url
    }

    override fun getItemCount() = doggoList.size

    class FavouritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.picture)
        var textView: TextView = itemView.findViewById(R.id.source)
    }
}