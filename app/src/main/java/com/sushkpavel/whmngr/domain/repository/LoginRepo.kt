package com.sushkpavel.whmngr.domain.repository

import com.sushkpavel.whmngr.data.model.LoginRequest
import com.sushkpavel.whmngr.domain.model.Token

interface LoginRepo {
    fun handleLogin(loginRequest: LoginRequest) : Token
}
