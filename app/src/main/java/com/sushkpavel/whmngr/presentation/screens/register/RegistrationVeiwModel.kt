package com.sushkpavel.whmngr.presentation.screens.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {
    private val _registrationState = mutableStateOf(RegistrationState())
    val registrationState: State<RegistrationState> = _registrationState

    fun onNameChange(newName: String) {
        _registrationState.value = _registrationState.value.copy(name = newName)
    }

    fun onCountryChange(newCountry: String) {
        _registrationState.value = _registrationState.value.copy(country = newCountry)
    }

    fun onAddressChange(newAddress: String) {
        _registrationState.value = _registrationState.value.copy(address = newAddress)
    }

    fun onPhoneChange(newPhone: String) {
        _registrationState.value = _registrationState.value.copy(phone = newPhone)
    }

    fun onEmailChange(newEmail: String) {
        _registrationState.value = _registrationState.value.copy(email = newEmail)
    }

    fun onPasswordChange(newPassword: String) {
        _registrationState.value = _registrationState.value.copy(password = newPassword)
    }

    fun onRegisterClick() {
        val state = _registrationState.value
        if (state.name.isNotEmpty() && state.country.isNotEmpty() && state.address.isNotEmpty() && state.phone.isNotEmpty() && state.email.isNotEmpty() && state.password.isNotEmpty()) {
            // Handle successful registration
            _registrationState.value = state.copy(isError = false)
        } else {
            _registrationState.value = state.copy(isError = true)
        }
    }
}
