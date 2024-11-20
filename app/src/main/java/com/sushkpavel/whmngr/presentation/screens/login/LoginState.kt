package com.sushkpavel.whmngr.presentation.screens.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isError: Boolean = false
)