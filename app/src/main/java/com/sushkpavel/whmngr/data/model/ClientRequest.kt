package com.sushkpavel.whmngr.data.model

data class ClientRequest(
    val name: String,
    val country: String,
    val address: String,
    val phone: String,
    val email: String,
    val password: String
)