package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class CseThumbnail(
    @SerializedName("height")
    val height: String?,
    @SerializedName("src")
    val src: String?,
    @SerializedName("width")
    val width: String?
)