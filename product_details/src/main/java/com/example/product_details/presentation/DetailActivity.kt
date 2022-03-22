package com.example.product_details.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.product_details.R
import com.example.product_details.domain.repository.DetailRepos
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    lateinit var viewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d("Details","fkmggkmf")
        viewModel=ViewModelProvider(this).get(DetailViewModel::class.java)
        /*viewModel.getDetailData()
        viewModel.myResponse.observe(this,){response->
            if (response.isSuccessful){
                Log.d("RespDetails",response.body()!![0].CPU+response.body()!![0].price.toString())
            }

        }*/
    }

}