package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class CseImage(
    @SerializedName("src")
    val src: String?
)