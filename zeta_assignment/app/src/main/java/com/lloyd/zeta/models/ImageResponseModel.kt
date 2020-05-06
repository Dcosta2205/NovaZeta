package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class ImageResponseModel(
    @SerializedName("context")
    val context: Context?,
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("queries")
    val queries: Queries?,
    @SerializedName("searchInformation")
    val searchInformation: SearchInformation?,
    @SerializedName("spelling")
    val spelling: Spelling?,
    @SerializedName("url")
    val url: Url?
)