package com.example.colemena_apoio.navigation
sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Login : Routes("login")
    object Cadastro : Routes("cadastro")
    object Home : Routes("home")
}