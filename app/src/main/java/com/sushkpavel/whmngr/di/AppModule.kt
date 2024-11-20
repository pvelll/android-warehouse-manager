package com.sushkpavel.whmngr.di

import com.sushkpavel.whmngr.presentation.screens.login.LoginViewModel
import com.sushkpavel.whmngr.presentation.screens.register.RegistrationViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module{
    viewModel {
        LoginViewModel()
    }
    viewModel {
        RegistrationViewModel()
    }
}