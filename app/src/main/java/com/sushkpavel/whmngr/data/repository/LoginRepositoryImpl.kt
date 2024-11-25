package com.sushkpavel.whmngr.data.repository

import com.sushkpavel.whmngr.data.model.LoginRequest
import com.sushkpavel.whmngr.domain.model.Token
import com.sushkpavel.whmngr.domain.repository.LoginRepository
import com.sushkpavel.whmngr.domain.repository.LoginRepository.Companion.END_POINT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class LoginRepositoryImpl(private val client: HttpClient) : LoginRepository {
    override suspend fun handleLogin(loginRequest: LoginRequest): Token {
        val response : Token= client.post(END_POINT) {
            contentType(ContentType.Application.Json)
            setBody(loginRequest)
        }.body()
        return response
    }
}

