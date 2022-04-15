package br.com.maicon.forum.model

import java.time.LocalDateTime

class Resposta (
    var id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    var topico: Topico,
    val solucao: Boolean? = null
        )
