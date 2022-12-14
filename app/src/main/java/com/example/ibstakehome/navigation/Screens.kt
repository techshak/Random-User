package com.example.ibstakehome.navigation

sealed class Screens(val route:String){
    object LoginScreen: Screens("login_screen")
    object UserScreen : Screens("user_screen")
}
