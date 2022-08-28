package com.example.main_screen.domain.repository

import com.example.main_screen.data.model.Home
import com.example.main_screen.data.network.MainScreenService
import retrofit2.Response

class MainScreenRepository(private val mainScreenService: MainScreenService) {
    suspend fun getHomeData():Home{
        return mainScreenService.getHomeData()
    }

}