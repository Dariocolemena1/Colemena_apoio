package com.example.colemena_apoio.TelaSplash


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.colemena_apoio.navigation.Routes

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Routes.Login.route) {
            popUpTo(Routes.Splash.route) {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "EduApoio",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Apoio Educacional Solidário")
        }
    }
}
