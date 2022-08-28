package com.example.product_details.domain.repository

import com.example.product_details.data.DetailsService
import com.example.product_details.data.model.Detail
import retrofit2.Response

class DetailsRepository(private val retroInterface: DetailsService) {
suspend fun getDataDetail():Detail{
    return retroInterface.getDataDetails()
}

}