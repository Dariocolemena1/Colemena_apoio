package com.example.colemena_apoio.viewmodel




import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.colemena_apoio.model.Apoio

class ApoioViewModel : ViewModel() {

    private var nextId = 1

    val listaApoios = mutableStateListOf<Apoio>()

    fun adicionarApoio(titulo: String, descricao: String) {
        listaApoios.add(
            Apoio(
                id = nextId++,
                titulo = titulo,
                descricao = descricao
            )
        )
    }

    fun removerApoio(id: Int) {
        listaApoios.removeAll { it.id == id }
    }

    fun editarApoio(id: Int, titulo: String, descricao: String) {
        listaApoios.find { it.id == id }?.apply {
            this.titulo = titulo
            this.descricao = descricao
        }
    }

    fun buscarApoios(texto: String): List<Apoio> {
        return listaApoios.filter { apoio ->
            apoio.titulo.contains(texto, ignoreCase = true) ||
                    apoio.descricao.contains(texto, ignoreCase = true)
        }
    }
}
