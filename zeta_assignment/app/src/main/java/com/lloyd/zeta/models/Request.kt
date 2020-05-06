package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("cx")
    val cx: String?,
    @SerializedName("inputEncoding")
    val inputEncoding: String?,
    @SerializedName("outputEncoding")
    val outputEncoding: String?,
    @SerializedName("safe")
    val safe: String?,
    @SerializedName("searchTerms")
    val searchTerms: String?,
    @SerializedName("startIndex")
    val startIndex: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("totalResults")
    val totalResults: String?
)