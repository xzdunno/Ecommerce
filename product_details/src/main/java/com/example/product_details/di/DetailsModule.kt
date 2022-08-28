package com.example.product_details.di

import com.example.product_details.data.DetailsService
import com.example.product_details.domain.repository.DetailsRepository
import com.example.product_details.presentation.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val detailsModule=module{
    single {
        provideDetailService(retrofit = get())
    }
single {
     DetailsRepository(retroInterface = get())
}
    viewModel {
        DetailViewModel(repos = get())
    }

}
fun provideDetailService(retrofit: Retrofit):DetailsService=retrofit.create(DetailsService::class.java)
