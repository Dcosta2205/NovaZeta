package com.lloyd.zeta.models

import com.google.gson.annotations.SerializedName

data class Spelling(
    @SerializedName("correctedQuery")
    val correctedQuery: String?,
    @SerializedName("htmlCorrectedQuery")
    val htmlCorrectedQuery: String?
)