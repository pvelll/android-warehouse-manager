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
import com.sushkpavel.whmngr.presentation.navigation.AppNavHost
import com.sushkpavel.whmngr.presentation.screens.login.LoginScreen
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenLogin
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenRegistration
import com.sushkpavel.whmngr.presentation.screens.register.RegistrationScreen
import com.sushkpavel.whmngr.presentation.theme.WhManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhManagerTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}



