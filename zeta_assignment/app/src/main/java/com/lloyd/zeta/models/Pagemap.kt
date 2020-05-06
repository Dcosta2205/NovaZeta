package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class Pagemap(
    @SerializedName("cse_image")
    val cseImage: List<CseImage?>?,
    @SerializedName("cse_thumbnail")
    val cseThumbnail: List<CseThumbnail?>?,
    @SerializedName("metatags")
    val metatags: List<Metatag?>?,
    @SerializedName("website")
    val website: List<Website?>?
)