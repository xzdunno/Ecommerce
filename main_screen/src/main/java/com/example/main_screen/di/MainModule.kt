package com.example.main_screen.di

import com.example.main_screen.data.network.MainScreenService
import com.example.main_screen.domain.repository.MainScreenRepository
import com.example.main_screen.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit
import org.koin.dsl.module

val mainScreenModule = module {
    single {
        provideMainScreenService(retrofit = get())
    }
    single {
        MainScreenRepository(mainScreenService = get())
    }
    viewModel {
        MainViewModel(repository = get())
    }
}

fun provideMainScreenService(retrofit: Retrofit): MainScreenService =
    retrofit.create(MainScreenService::class.java)