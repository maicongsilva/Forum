package br.com.maicon.forum.repository

import br.com.maicon.forum.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository: JpaRepository<Resposta,Long> {
}