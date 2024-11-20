package com.sushkpavel.whmngr.presentation.screens.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    fun onEmailChange(newEmail: String) {
        _loginState.value = _loginState.value.copy(email = newEmail)
    }

    fun onPasswordChange(newPassword: String) {
        _loginState.value = _loginState.value.copy(password = newPassword)
    }

    fun onLoginClick() {
        if (_loginState.value.email.isNotEmpty() && _loginState.value.password.isNotEmpty()) {
            //TODO
            _loginState.value = _loginState.value.copy(isError = false)
        } else {
            _loginState.value = _loginState.value.copy(isError = true)
        }
    }
}
