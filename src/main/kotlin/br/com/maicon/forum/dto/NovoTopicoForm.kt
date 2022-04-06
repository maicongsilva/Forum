package br.com.maicon.forum.dto

import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Usuario

class NovoTopicoForm(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)
