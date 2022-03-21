package com.example.ecommerce.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
//val BASE_URL="https://shopapi-0575.restdb.io/rest/"
//
//    @Provides
//    @Singleton
//    fun getRetroInterface(retrofit: Retrofit): RetroInterface {
//        return retrofit.create(RetroInterface::class.java)
//    }
//    @Provides
//    @Singleton
//    fun getNetworkInstance(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
}