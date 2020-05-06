package com.lloyd.zeta.models

sealed class ImageUIModel {

    class OnSuccess(val itemsList: List<Item?>?) : ImageUIModel()

    class OnFailure(val errorMessage: String?) : ImageUIModel()
}