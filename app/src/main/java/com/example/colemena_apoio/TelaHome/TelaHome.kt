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

// Certifique-se de que estes nomes de pacotes coincidem com suas pastas
import com.example.colemena_apoio.model.Apoio
import com.example.colemena_apoio.viewmodel.ApoioViewModel

@Composable
fun HomeScreen(
    viewModel: ApoioViewModel = viewModel()
) {
    var apoioSelecionado by remember { mutableStateOf<Apoio?>(null) }
    var mostrarEditar by remember { mutableStateOf(false) }

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

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    viewModel.adicionarApoio("Material Escolar", "Distribuição de itens", "Material")
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Adicionar Material Escolar") }

            Button(
                onClick = {
                    viewModel.adicionarApoio("Reforço Escolar", "Aulas de matemática", "Reforço")
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Adicionar Reforço Escolar") }
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
                        Text(
                            text = "Categoria: ${apoio.categoria}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = {
                                apoioSelecionado = apoio
                                mostrarEditar = true
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

    if (mostrarEditar && apoioSelecionado != null) {
        EditarApoioDialog(
            apoio = apoioSelecionado!!,
            onSalvar = { novoTitulo, novaDescricao ->
                viewModel.editarApoio(apoioSelecionado!!.id, novoTitulo, novaDescricao)
                mostrarEditar = false
                apoioSelecionado = null
            },
            onCancelar = {
                mostrarEditar = false
                apoioSelecionado = null
            }
        )
    }
}

@Composable
fun EditarApoioDialog(
    apoio: Apoio,
    onSalvar: (String, String) -> Unit,
    onCancelar: () -> Unit
) {
    var txtTitulo by remember { mutableStateOf(apoio.titulo) }
    var txtDescricao by remember { mutableStateOf(apoio.descricao) }

    AlertDialog(
        onDismissRequest = onCancelar,
        title = { Text("Editar Apoio") },
        text = {
            Column {
                OutlinedTextField(
                    value = txtTitulo,
                    onValueChange = { txtTitulo = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = txtDescricao,
                    onValueChange = { txtDescricao = it },
                    label = { Text("Descrição") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = { onSalvar(txtTitulo, txtDescricao) }) { Text("Salvar") }
        },
        dismissButton = {
            TextButton(onClick = onCancelar) { Text("Cancelar") }
        }
    )
}