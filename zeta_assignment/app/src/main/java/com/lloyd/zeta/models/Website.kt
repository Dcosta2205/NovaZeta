package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class Website(
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)