package com.example.product_details.domain.repository

import com.example.product_details.data.model.Detail
import com.example.product_details.data.network.DetailRetroInterface
import retrofit2.Response
import javax.inject.Inject

class DetailRepos @Inject constructor(private val retroInterface: DetailRetroInterface) {
suspend fun getDataDetail():Response<List<Detail>>{
    return retroInterface.getDataDetails()
}
}