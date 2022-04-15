package br.com.maicon.forum.dto

import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Usuario
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class NovoTopicoForm(
    @field:NotEmpty @field:Size(min = 5, max = 100) val titulo: String,
    @field:NotEmpty val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)
