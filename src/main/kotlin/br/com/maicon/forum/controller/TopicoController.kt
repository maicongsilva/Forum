package br.com.maicon.forum.controller

import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Topico
import br.com.maicon.forum.model.Usuario
import br.com.maicon.forum.service.TopicoService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<Topico>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico{
        return service.buscarPorId(id)
    }
}