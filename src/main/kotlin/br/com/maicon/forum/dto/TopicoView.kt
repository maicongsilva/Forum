package br.com.maicon.forum.dto

import br.com.maicon.forum.model.StatusTopico
import java.time.LocalDateTime

class TopicoView(
    val id: Long ? = null,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val dataCriacao: LocalDateTime = LocalDateTime.now()
)
