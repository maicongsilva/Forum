package br.com.maicon.forum.service

import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Usuario
import br.com.maicon.forum.repository.UsuarioRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
       return repository.getById(id)
    }

}
