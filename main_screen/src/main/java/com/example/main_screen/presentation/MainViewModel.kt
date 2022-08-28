package com.example.main_screen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.main_screen.domain.repository.MainScreenRepository
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import com.example.main_screen.data.model.Home
import kotlinx.coroutines.launch
class MainViewModel(private val repository: MainScreenRepository): ViewModel() {
   var myResponse: MutableLiveData<Home> = MutableLiveData()
fun getHomeData(){
   viewModelScope.launch{
      myResponse?.value =repository.getHomeData()
      Log.d("viewM", myResponse?.value!!.best_seller[0].title)}
}
}