package com.lloyd.zeta.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lloyd.zeta.R
import com.lloyd.zeta.interfaces.ImageClickListener
import com.lloyd.zeta.models.Item
import kotlinx.android.synthetic.main.image_list_recycler_items.view.*

class ImageListViewHolder(itemView: View, private val imageClickListener: ImageClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun onBind(item: Item) {
        val url = item.pagemap?.cseThumbnail?.first()?.src
        itemView.apply {
            Glide.with(itemView.context)
                .load(url)
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(iv_image_cse)
            tv_title.text = item.title
            tv_link.text = item.link

            iv_image_cse.setOnClickListener {
                imageClickListener.onImageClicked(adapterPosition, item)
            }
        }
    }
}