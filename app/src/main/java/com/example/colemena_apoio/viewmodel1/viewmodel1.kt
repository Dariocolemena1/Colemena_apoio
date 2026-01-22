package com.example.colemena_apoio.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.colemena_apoio.model.Apoio
import java.util.UUID

class ApoioViewModel : ViewModel() {
    private val _listaApoios = mutableStateListOf<Apoio>()
    val listaApoios: List<Apoio> = _listaApoios

    fun adicionarApoio(titulo: String, descricao: String, categoria: String) {
        val novo = Apoio(
            id = UUID.randomUUID().toString(),
            titulo = titulo,
            descricao = descricao,
            categoria = categoria
        )
        _listaApoios.add(novo)
    }

    fun removerApoio(id: String) {
        _listaApoios.removeIf { it.id == id }
    }

    fun editarApoio(id: String, novoTitulo: String, novaDescricao: String) {
        val index = _listaApoios.indexOfFirst { it.id == id }
        if (index != -1) {
            _listaApoios[index] = _listaApoios[index].copy(
                titulo = novoTitulo,
                descricao = novaDescricao
            )
        }
    }
}