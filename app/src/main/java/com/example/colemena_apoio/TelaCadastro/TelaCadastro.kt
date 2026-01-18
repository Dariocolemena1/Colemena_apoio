package com.example.colemena_apoio.ui.screens.cadastro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable

import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.colemena_apoio.ui.screens.cadastro.CadastroScreen
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.colemena_apoio.navigation.Routes

@Composable
fun CadastroScreen(navController: NavHostController) { // Alterado para NavHostController

    // Estados para os campos de texto
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cadastro",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome completo") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp)) // Espaçamento entre campos

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp)) // Espaçamento entre campos

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Lógica de cadastro aqui
                // Após cadastrar, voltamos para o Login
                navController.navigate(Routes.Login.route) {
                    // Limpa a tela de cadastro da pilha para não voltar ao clicar em "back"
                    popUpTo(Routes.Cadastro.route) { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar")
        }

        TextButton(
            onClick = {
                navController.popBackStack() // Volta para a tela anterior (Login)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Já tem uma conta? Faça login")
        }
    }
}