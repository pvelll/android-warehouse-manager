package com.sushkpavel.whmngr.domain.repository

import com.sushkpavel.whmngr.data.model.LoginRequest
import com.sushkpavel.whmngr.domain.model.Token

interface LoginRepository {
    suspend fun handleLogin(loginRequest: LoginRequest) : Token

    companion object{
        const val END_POINT : String = "http://127.0.0.1:8082/api/login"
    }
}
