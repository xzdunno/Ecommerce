package com.example.product_details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.product_details.data.model.Detail
import com.example.product_details.domain.repository.DetailsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel(private val repos: DetailsRepository):ViewModel() {
    var myResponse: MutableLiveData<Detail> = MutableLiveData()
    fun getDetailData(){
        viewModelScope.launch{myResponse.value=repos.getDataDetail()}
    }
}