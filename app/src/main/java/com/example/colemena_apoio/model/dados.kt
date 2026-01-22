package com.example.colemena_apoio.model

// Usar "data class" resolve o erro de inicialização automaticamente
data class Apoio(
    val id: String,
    val titulo: String,
    val descricao: String,
    val categoria: String = "Geral"
)