package com.example.colemena_apoio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.colemena_apoio.TelaSplash.SplashScreen
import com.example.colemena_apoio.ui.screens.login.LoginScreen
import com.example.colemena_apoio.ui.screens.cadastro.CadastroScreen
import com.example.colemena_apoio.ui.screens.home.HomeScreen
import com.example.colemena_apoio.ui.screens.busca.BuscaScreen

import com.example.colemena_apoio.navigation.Routes

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {

        composable(Routes.Splash.route) {
            SplashScreen(navController)
        }

        composable(Routes.Login.route) {
            LoginScreen(navController)
        }

        composable(Routes.Cadastro.route) {
            CadastroScreen(navController)
        }

        composable(Routes.Home.route) {
            HomeScreen()
        }
        composable(Routes.Busca.route) {
            BuscaScreen()
        }

    }
}
