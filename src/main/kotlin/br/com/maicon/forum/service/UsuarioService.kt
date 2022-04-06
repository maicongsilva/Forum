package br.com.maicon.forum.service

import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UsuarioService(private var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com"
        )
        val usuario2 = Usuario(
            id = 2,
            nome = "Maicon Gomes",
            email = "maicon@email.com"
        )
        val usuario3 = Usuario(
            id = 3,
            nome = "Paulo de Jesus",
            email = "paulo@email.com"
        )
        val usuario4 = Usuario(
            id = 4,
            nome = "Diego Silva",
            email = "diego@email.com"
        )

        usuarios = Arrays.asList(usuario,usuario2,usuario3,usuario4)
    }

    fun buscarPorId(idAutor: Long): Usuario {
        return usuarios.stream().filter({
            u -> u.id == idAutor
        }).findFirst().get()
    }

}
