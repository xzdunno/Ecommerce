package com.example.ecommerce.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.main_screen.domain.repository.Repository
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import com.example.main_screen.data.model.Home
import kotlinx.coroutines.launch
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {
   var myResponse: MutableLiveData<Response<List<Home>>> = MutableLiveData()
fun getHomeData(){
   viewModelScope.launch{myResponse.value=repository.getHomeData()}
}

}