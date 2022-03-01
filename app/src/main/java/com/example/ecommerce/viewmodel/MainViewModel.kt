package com.example.ecommerce.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.ecommerce.repository.Repository
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import com.example.ecommerce.model.BestSeller
import com.example.ecommerce.model.Home
import kotlinx.coroutines.launch
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {
   var myResponse: MutableLiveData<Response<List<Home>>> = MutableLiveData()
fun getHomeData(){
   viewModelScope.launch{myResponse.value=repository.getHomeData()}
}

}