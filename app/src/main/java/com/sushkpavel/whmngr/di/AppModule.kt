package com.sushkpavel.whmngr.di

import com.sushkpavel.whmngr.presentation.screens.login.LoginViewModel
import com.sushkpavel.whmngr.presentation.screens.register.RegistrationViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    factory { HttpClient(CIO)
    }

    viewModel {
        LoginViewModel()
    }
    viewModel {
        RegistrationViewModel()
    }
}
