package com.example.ecommerce.repository

import com.example.ecommerce.model.Home
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.*

interface RetroInterface {
    @Headers("x-apikey: 61ddae2e95cb716ea5ee48e4")
    @GET("home?")
    suspend fun getHomeData():Response<List<Home>>
}