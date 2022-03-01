package com.example.ecommerce.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.ecommerce.repository.RetroInterface
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
val BASE_URL="https://shopapi-0575.restdb.io/rest/"

    @Provides
    @Singleton
    fun getRetroInterface(retrofit: Retrofit): RetroInterface {
        return retrofit.create(RetroInterface::class.java)
    }
    @Provides
    @Singleton
    fun getNetworkInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}