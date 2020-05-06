package com.lloyd.zeta.interfaces

import com.lloyd.zeta.models.ImageResponseModel
import com.lloyd.zeta.models.Item

interface ImageClickListener {

    fun onImageClicked(position: Int, item: Item)
}