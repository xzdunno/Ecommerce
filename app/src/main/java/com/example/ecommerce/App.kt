package com.example.ecommerce

import android.app.Application
import com.example.main_screen.di.mainScreenModule
import com.example.product_details.di.detailsModule
import com.github.astat1cc.sergeybalakintesttask.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                networkModule,
                mainScreenModule,
                detailsModule
                /*cartScreenModule,
                databaseModule*/
            )
        }
    }
}