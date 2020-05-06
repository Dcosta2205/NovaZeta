package com.lloyd.zeta.repository

import com.lloyd.zeta.Utils.API_KEY
import com.lloyd.zeta.Utils.cx
import com.lloyd.zeta.models.ImageResponseModel
import io.reactivex.Single
import network.ApiInterface
import network.RetrofitService

class SearchRepository {

    private val apiInterface = RetrofitService.getRetrofitService().create(ApiInterface::class.java)

    fun callSearchApi(searchQuery: String): Single<ImageResponseModel> {
        return apiInterface.getImageDetails(searchQuery, cx = cx, apiKey = API_KEY)
    }
}