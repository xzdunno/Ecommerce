package com.example.main_screen.data.network

import com.example.main_screen.data.model.Home
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.*

interface MainScreenService {
    @GET("/v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomeData():Home
}