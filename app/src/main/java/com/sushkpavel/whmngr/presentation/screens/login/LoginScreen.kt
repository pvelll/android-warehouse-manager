package com.sushkpavel.whmngr.presentation.screens.login

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sushkpavel.whmngr.R
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenRegistration
import com.sushkpavel.whmngr.presentation.utils.ClickableText
import com.sushkpavel.whmngr.presentation.utils.CustomButton
import com.sushkpavel.whmngr.presentation.utils.CustomOutlinedTextField
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavHostController,
    viewModel: LoginViewModel = koinViewModel()
) {
    val loginState by viewModel.loginState

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.login),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        CustomOutlinedTextField(
            value = loginState.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = stringResource(R.string.email),
            isError = loginState.isError
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutlinedTextField(
            value = loginState.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = stringResource(R.string.password),
            isError = loginState.isError,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            text = stringResource(R.string.login),
            onClick = { viewModel.onLoginClick() }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ClickableText(
            text = stringResource(R.string.no_account_notification),
            onClick = { navController.navigate(ScreenRegistration) }
        )
        if (loginState.isError) {
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
fun LoginScreenPreview() {
    val fakeNavController = rememberNavController()
    val fakeViewModel = LoginViewModel()

    LoginScreen(
        navController = fakeNavController,
        viewModel = fakeViewModel
    )
}
