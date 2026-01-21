package com.example.colemena_apoio.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

// Importações do seu projeto (Verifique se esses nomes de pacotes existem)
import com.example.colemena_apoio.model.Apoio
import com.example.colemena_apoio.viewmodel.ApoioViewModel

@Composable
fun HomeScreen(
    viewModel: ApoioViewModel = viewModel()
) {
    // Usando .value para manter compatibilidade com seu código original
    val apoioSelecionado = remember { mutableStateOf<Apoio?>(null) }
    val mostrarEditar = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Apoios Educacionais",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botões de Adição
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.adicionarApoio("Entrega de Material Escolar", "Distribuição de itens")
                }
            ) { Text("Entrega de Material Escolar") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.adicionarApoio("Acompanhamento Pedagógico", "Desempenho acadêmico")
                }
            ) { Text("Acompanhamento Pedagógico") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.adicionarApoio("Reforço Escolar", "Aulas extras")
                }
            ) { Text("Reforço Escolar") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(viewModel.listaApoios) { apoio ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = apoio.titulo, fontWeight = FontWeight.Bold)
                        Text(text = apoio.descricao)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = {
                                apoioSelecionado.value = apoio
                                mostrarEditar.value = true
                            }) { Text("Editar") }

                            TextButton(onClick = {
                                viewModel.removerApoio(apoio.id)
                            }) { Text("Excluir", color = Color.Red) }
                        }
                    }
                }
            }
        }
    }

    if (mostrarEditar.value && apoioSelecionado.value != null) {
        // Certifique-se de que esta função existe no seu projeto!
        EditarApoioDialog(
            apoio = apoioSelecionado.value!!,
            onSalvar = { titulo, descricao ->
                viewModel.editarApoio(apoioSelecionado.value!!.id, titulo, descricao)
                mostrarEditar.value = false
            },
            onCancelar = { mostrarEditar.value = false }
        )
    }
}

// Componente Placeholder caso você ainda não tenha criado o Dialog
@Composable
fun EditarApoioDialog(
    apoio: Apoio,
    onSalvar: (String, String) -> Unit,
    onCancelar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCancelar,
        title = { Text("Editar Apoio") },
        text = { Text("Deseja salvar as alterações em ${apoio.titulo}?") },
        confirmButton = {
            Button(onClick = { onSalvar(apoio.titulo, apoio.descricao) }) { Text("Salvar") }
        },
        dismissButton = {
            TextButton(onClick = onCancelar) { Text("Cancelar") }
        }
    )
}