package br.com.maicon.forum.controller

import br.com.maicon.forum.dto.NovoTopicoDto
import br.com.maicon.forum.dto.NovoTopicoForm
import br.com.maicon.forum.dto.TopicoView
import br.com.maicon.forum.model.Topico
import br.com.maicon.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody topico: NovoTopicoForm){
        service.cadastrar(topico)
    }
}