package com.example.ecommerce.di

import com.example.main_screen.data.network.RetroInterface
import com.example.product_details.data.network.DetailRetroInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DetailsModule {
    val BASE_URL="https://shopapi-0575.restdb.io/rest/"
    @Provides
    @Singleton
    fun getDetailRetroInt(retrofit: Retrofit): DetailRetroInterface {
        return retrofit.create(DetailRetroInterface::class.java)
    }
   /* @Provides
    @Singleton
    fun getDetailInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }*/
}