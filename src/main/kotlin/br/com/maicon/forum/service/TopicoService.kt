package br.com.maicon.forum.service

import br.com.maicon.forum.dto.NovoTopicoDto
import br.com.maicon.forum.dto.NovoTopicoForm
import br.com.maicon.forum.dto.TopicoView
import br.com.maicon.forum.mapper.TopicoFormMapper
import br.com.maicon.forum.mapper.TopicoViewMapper
import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Topico
import br.com.maicon.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico>,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView>{
        return topicos.stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
       val topico = topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm){
       val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos =  topicos.plus(topico)
    }


}