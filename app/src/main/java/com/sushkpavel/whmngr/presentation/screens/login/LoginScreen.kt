package com.sushkpavel.whmngr.presentation.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sushkpavel.whmngr.R
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenRegistration
import com.sushkpavel.whmngr.presentation.utils.ClickableText
import com.sushkpavel.whmngr.presentation.utils.CustomButton
import com.sushkpavel.whmngr.presentation.utils.CustomOutlinedTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavHostController = rememberNavController(),
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

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
            value = email,
            onValueChange = { email = it },
            label = stringResource(R.string.email),
            isError = isError
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = stringResource(R.string.password),
            isError = isError,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            text = stringResource(R.string.login),
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    // navController.navigate(ScreenHome)
                } else {
                    isError = true
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ClickableText(
            text = stringResource(R.string.no_account_notification),
            onClick = { navController.navigate(ScreenRegistration) }
        )
        if (isError) {
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
    LoginScreen()
}