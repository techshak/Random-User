package com.example.ibstakehome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ibstakehome.ui.presentation.login.LoginScreen

@Composable
fun Navigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.LoginScreen.route){
        composable(
            route = Screens.LoginScreen.route,
        ){
            LoginScreen(navController = navController)
        }
    }
}