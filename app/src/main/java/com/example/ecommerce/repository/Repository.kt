package com.example.ecommerce.repository

import android.util.Log
import com.example.ecommerce.model.Home
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import retrofit2.Callback
import java.util.*

class Repository @Inject constructor(private val retroInterface: RetroInterface) {
    suspend fun getHomeData():Response<List<Home>>{
/*val call:Call<List<Home>> =retroInterface.getHomeData()
        call.enqueue(object: Callback<List<Home>>{
            override fun onResponse(call: Call<List<Home>>, response: Response<List<Home>>) {
                if(response.isSuccessful){
                    for (i in 0..3){
                        val it=response.body()!![0].best_seller[i]!!
Log.d("responseHome","${it.id}+${it.title}+${it.discount_price}")
                    }
                }
            }

            override fun onFailure(call: Call<List<Home>>, t: Throwable) {
                //
            }
        })*/
        return retroInterface.getHomeData()
    }
}