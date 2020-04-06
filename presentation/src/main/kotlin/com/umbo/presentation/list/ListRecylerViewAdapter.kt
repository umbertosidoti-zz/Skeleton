package com.umbo.presentation.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.umbo.data.ImageLoader
import com.umbo.presentation.R
import kotlinx.android.synthetic.main.list_recyclerview_item.view.*

class ListRecylerViewAdapter(private val imageLoader: ImageLoader) : RecyclerView.Adapter<ListRecylerViewAdapter.ListAdapterViewHolder>() {

    private val photos: MutableList<PhotoViewState> = mutableListOf()
    var onItemClick: ((String) -> Unit)? = null

    fun addPhotos(photos: List<PhotoViewState>){
        this.photos.clear()
        this.photos.addAll(photos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder {
        return ListAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_recyclerview_item,
                parent,
                false)
        )
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        with(holder){
            title.text = photos[position].title
            imageLoader.load(photos[position].url, icon)
        }
    }

    inner class ListAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.listItemIcon
        val title: TextView = itemView.listItemTitle
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(photos[adapterPosition].id)
            }
        }
    }
}