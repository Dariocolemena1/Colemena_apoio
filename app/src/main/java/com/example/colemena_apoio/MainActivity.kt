package com.example.colemena_apoio



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.colemena_apoio.ui.theme.Colemena_apoioTheme
import com.example.colemena_apoio.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Colemena_apoioTheme {
                // A Surface define o fundo de toda a aplicação
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // CORREÇÃO AQUI: A variável deve ser criada DENTRO do setContent
                    // e ANTES de ser usada no NavGraph.
                    val navController = rememberNavController()

                    // Agora o 'navController' existe para esta linha:
                    NavGraph(navController = navController)
                }
            }
        }
    }
}