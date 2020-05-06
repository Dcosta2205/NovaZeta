package com.lloyd.zeta.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lloyd.zeta.interfaces.ImageClickListener

class ImageListViewHolder(itemView: View, private val imageClickListener: ImageClickListener) :
    RecyclerView.ViewHolder(itemView) {
}