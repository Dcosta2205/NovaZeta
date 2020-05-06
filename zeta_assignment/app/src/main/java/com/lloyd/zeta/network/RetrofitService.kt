package com.lloyd.zeta.network

import com.lloyd.zeta.Utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private lateinit var mRetrofit: Retrofit

    fun getRetrofitService(): Retrofit {
        if (::mRetrofit.isInitialized.not()) {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
                ).build()
        }
        return mRetrofit
    }
}