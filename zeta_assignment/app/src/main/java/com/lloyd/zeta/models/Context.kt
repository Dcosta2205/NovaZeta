package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class Context(
    @SerializedName("title")
    val title: String?
)