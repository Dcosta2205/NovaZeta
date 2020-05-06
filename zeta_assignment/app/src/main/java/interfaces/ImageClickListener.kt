package interfaces

import com.lloyd.zeta.models.ImageResponseModel

interface ImageClickListener {

    fun onImageClicked(position: Int, model: ImageResponseModel)
}