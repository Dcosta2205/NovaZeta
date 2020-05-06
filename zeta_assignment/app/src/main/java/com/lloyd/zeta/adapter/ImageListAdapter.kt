package com.lloyd.zeta.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lloyd.zeta.R
import com.lloyd.zeta.interfaces.ImageClickListener
import com.lloyd.zeta.models.Item
import com.lloyd.zeta.viewholder.ImageListViewHolder

class ImageListAdapter(
    private val imageClickListener: ImageClickListener,
    private val itemsList: List<Item>
) :
    RecyclerView.Adapter<ImageListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_list_recycler_items, parent, false)
        return ImageListViewHolder(view, imageClickListener)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        holder.onBind(itemsList[position])
    }
}