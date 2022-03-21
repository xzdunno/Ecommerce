package com.example.main_screen.domain.repository

import com.example.main_screen.data.model.Home
import com.example.main_screen.data.network.RetroInterface
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val retroInterface: RetroInterface) {
    suspend fun getHomeData():Response<List<Home>>{
        return retroInterface.getHomeData()
    }
}