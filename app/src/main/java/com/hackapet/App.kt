package com.hackapet

import android.app.Application
import com.hackapet.petsync_android.ui.screens.details.DetailsViewModel
import com.hackapet.petsync_android.ui.screens.home.HomeViewModel
import com.hackapet.petsync_kmp.di.AndroidAppModule
import com.hackapet.petsync_kmp.di.AppModule
import com.hackapet.petsync_kmp.di.Keys
import com.hackapet.petsync_kmp.di.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(appModule = configModule(this), modules = listOf(module {
            viewModel { HomeViewModel(get()) }
            viewModel { DetailsViewModel(get()) }
        }))
    }

    private fun configModule(context: Application): AppModule {
        return AndroidAppModule.Builder()
            .withContext(context)
            .withUrl("baseUrl")
            .withKeys(
                Keys(
                    "public key",
                    "private key"
                )
            )
            .build()
    }
}