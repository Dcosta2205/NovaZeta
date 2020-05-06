package com.lloyd.zeta.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lloyd.zeta.R
import com.lloyd.zeta.viewholder.ImageListViewHolder
import com.lloyd.zeta.interfaces.ImageClickListener

class ImageListAdapter(private val imageClickListener: ImageClickListener) :
    RecyclerView.Adapter<ImageListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_list_recycler_items, parent, false)
        return ImageListViewHolder(view, imageClickListener)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}