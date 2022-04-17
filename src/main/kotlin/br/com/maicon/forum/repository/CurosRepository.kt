package br.com.maicon.forum.repository

import br.com.maicon.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CurosRepository: JpaRepository<Curso,Long> {
}