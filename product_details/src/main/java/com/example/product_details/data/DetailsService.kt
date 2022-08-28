package com.example.product_details.data

import com.example.product_details.data.model.Detail
import retrofit2.http.GET

interface DetailsService {
    @GET("/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDataDetails():Detail
}