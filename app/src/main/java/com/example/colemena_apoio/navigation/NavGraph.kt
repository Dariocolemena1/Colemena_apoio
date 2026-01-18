package com.example.colemena_apoio.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// IMPORTS DAS TELAS
import com.example.colemena_apoio.ui.screens.login.LoginScreen
import com.example.colemena_apoio.ui.screens.cadastro.CadastroScreen // A linha que faltava
import com.example.colemena_apoio.ui.screens.home.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController)
        }

        // A linha 22 que estava com erro agora funciona:
        composable("cadastro") {
            CadastroScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }
    }
}