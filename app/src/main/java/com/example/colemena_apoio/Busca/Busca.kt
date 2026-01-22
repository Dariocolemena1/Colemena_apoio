package com.example.colemena_apoio.Busca

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.colemena_apoio.viewmodel1.ApoioViewModel

// Outros imports...

@Composable
fun BuscaScreen(viewModel: ApoioViewModel = viewModel()) {
    var textoBusca by remember { mutableStateOf("") }
    var categoriaSelecionada by remember { mutableStateOf("Todas") }

    // Linha 26 corrigida:
    val resultados = viewModel.buscarApoios(textoBusca, categoriaSelecionada)

    // ... restante do código (LazyColumn, etc)
}

private fun ApoioViewModel.buscarApoios(
    textoBusca: String,
    categoriaSelecionada: String
) {
    TODO("Not yet implemented")
}
