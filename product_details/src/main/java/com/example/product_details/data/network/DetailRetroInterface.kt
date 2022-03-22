package com.example.product_details.data.network

import com.example.product_details.data.model.Detail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface DetailRetroInterface {
    @Headers("x-apikey:61ddae2e95cb716ea5ee48e4")
    @GET("detail?")
    suspend fun getDataDetails():Response<List<Detail>>
}