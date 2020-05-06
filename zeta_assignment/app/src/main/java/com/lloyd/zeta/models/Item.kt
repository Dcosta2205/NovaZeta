package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("cacheId")
    val cacheId: String?,
    @SerializedName("displayLink")
    val displayLink: String?,
    @SerializedName("formattedUrl")
    val formattedUrl: String?,
    @SerializedName("htmlFormattedUrl")
    val htmlFormattedUrl: String?,
    @SerializedName("htmlSnippet")
    val htmlSnippet: String?,
    @SerializedName("htmlTitle")
    val htmlTitle: String?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("pagemap")
    val pagemap: Pagemap?,
    @SerializedName("snippet")
    val snippet: String?,
    @SerializedName("title")
    val title: String?
)