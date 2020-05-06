package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class SearchInformation(
    @SerializedName("formattedSearchTime")
    val formattedSearchTime: String?,
    @SerializedName("formattedTotalResults")
    val formattedTotalResults: String?,
    @SerializedName("searchTime")
    val searchTime: Double?,
    @SerializedName("totalResults")
    val totalResults: String?
)