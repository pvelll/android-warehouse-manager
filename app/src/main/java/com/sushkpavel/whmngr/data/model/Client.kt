package com.sushkpavel.whmngr.data.model

data class Client(
    var id: Long,
    val name: String,
    val country: String,
    val address: String,
    val ownershipForm: String? = null,
    val phone: String,
    val email: String,
    val password: String,
    val managerName: String? = null
)