package com.lloyd.zeta.models

sealed class ImageUIModel {

    class OnSuccess(val pageMap: Pagemap?) : ImageUIModel()

    class OnFailure(val errorMessage: String?) : ImageUIModel()
}