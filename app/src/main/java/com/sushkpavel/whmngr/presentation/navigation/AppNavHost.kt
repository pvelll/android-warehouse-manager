package com.sushkpavel.whmngr.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenLogin
import com.sushkpavel.whmngr.presentation.navigation.routes.ScreenRegistration
import com.sushkpavel.whmngr.presentation.screens.login.LoginScreen
import com.sushkpavel.whmngr.presentation.screens.register.RegistrationScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenLogin
    ) {
        composable<ScreenLogin> {
            LoginScreen(
                navController = navController
            )
        }
        composable<ScreenRegistration> {
            RegistrationScreen(navController = navController)
        }
    }
}