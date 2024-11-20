package com.sushkpavel.whmngr.presentation.screens.register

data class RegistrationState(
    val name: String = "",
    val country: String = "",
    val address: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val isError: Boolean = false
)
