package com.sushkpavel.whmngr.presentation.screens.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sushkpavel.whmngr.R
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenLogin
import com.sushkpavel.whmngr.presentation.utils.ClickableText
import com.sushkpavel.whmngr.presentation.utils.CustomButton
import com.sushkpavel.whmngr.presentation.utils.CustomOutlinedTextField
import org.koin.androidx.compose.koinViewModel


@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavHostController,
    viewModel: RegistrationViewModel = koinViewModel()
) {
    val registrationState by viewModel.registrationState

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.registration),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        CustomOutlinedTextField(
            value = registrationState.name,
            onValueChange = { viewModel.onNameChange(it) },
            label = stringResource(R.string.name),
            isError = registrationState.isError
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutlinedTextField(
            value = registrationState.country,
            onValueChange = { viewModel.onCountryChange(it) },
            label = stringResource(R.string.country),
            isError = registrationState.isError
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutlinedTextField(
            value = registrationState.address,
            onValueChange = { viewModel.onAddressChange(it) },
            label = stringResource(R.string.address),
            isError = registrationState.isError
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutlinedTextField(
            value = registrationState.phone,
            onValueChange = { viewModel.onPhoneChange(it) },
            label = stringResource(R.string.phone),
            isError = registrationState.isError
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutlinedTextField(
            value = registrationState.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = stringResource(R.string.email),
            isError = registrationState.isError
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutlinedTextField(
            value = registrationState.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = stringResource(R.string.password),
            isError = registrationState.isError,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            text = stringResource(R.string.register),
            onClick = { viewModel.onRegisterClick() }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ClickableText(
            text = stringResource(R.string.already_have_account),
            onClick = { navController.navigate(ScreenLogin) }
        )
        if (registrationState.isError) {
            Text(
                text = stringResource(R.string.empty_field_notification),
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {

    RegistrationScreen(navController = rememberNavController(), viewModel = RegistrationViewModel())
}
