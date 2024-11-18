package com.sushkpavel.whmngr.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sushkpavel.whmngr.R
import com.sushkpavel.whmngr.presentation.screens.LoginScreen
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenLogin
import com.sushkpavel.whmngr.presentation.theme.WhManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhManagerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenLogin
                ) {
                    composable<ScreenLogin> {
                        LoginScreen(
                            modifier = Modifier.fillMaxSize(),
                            navController = navController,
                            loginText = getString(R.string.login),
                            emailLabel = getString(R.string.email),
                            passwordLabel = getString(R.string.password),
                            emptyFieldNotification = getString(R.string.empty_field_notification)
                        )
                    }
                }
            }
        }
    }
}



