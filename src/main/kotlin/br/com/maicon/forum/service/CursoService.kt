package br.com.maicon.forum.service

import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.repository.CurosRepository
import br.com.maicon.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class CursoService(private val repository: CurosRepository){

    fun buscarPorId(id: Long): Curso {
        return repository.getById(id)
    }
}
