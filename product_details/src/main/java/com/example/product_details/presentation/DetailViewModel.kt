package com.example.product_details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.product_details.data.model.Detail
import com.example.product_details.domain.repository.DetailRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repos: DetailRepos):ViewModel() {
    var myResponse: MutableLiveData<Response<List<Detail>>> = MutableLiveData()
    fun getDetailData(){
        viewModelScope.launch{myResponse.value=repos.getDataDetail()}
    }
}