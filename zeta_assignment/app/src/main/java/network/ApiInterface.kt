package network

import com.lloyd.zeta.models.ImageResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/customsearch/v1")
    fun getImageDetails(
        @Query("q") searchImageName: String,
        @Query("cx") cx: String,
        @Query("key") apiKey: String
    ): Single<ImageResponseModel>
}