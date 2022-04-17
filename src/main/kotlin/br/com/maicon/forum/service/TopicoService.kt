package br.com.maicon.forum.service

import br.com.maicon.forum.dto.AtualizacaoTopicoForm
import br.com.maicon.forum.dto.NovoTopicoDto
import br.com.maicon.forum.dto.NovoTopicoForm
import br.com.maicon.forum.dto.TopicoView
import br.com.maicon.forum.exception.NotFoundException
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
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoudMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<TopicoView>{
        return topicos.stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
       val topico = topicos.stream().filter({
            t -> t.id == id
        }).findFirst().orElseThrow{NotFoundException(notFoudMessage)}
        return topicoViewMapper.map(topico)
    }

    fun buscarTopicoPorId(id: Long): Topico{
        val topico = topicos.stream().filter({
                t -> t.id == id
        }).findFirst().orElseThrow{NotFoundException(notFoudMessage)}
        return topico
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView{
       val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos =  topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView{
        val topico = topicos.stream().filter({
                t -> t.id == form.id
        }).findFirst().orElseThrow{NotFoundException(notFoudMessage)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            status = topico.status,
            dataCriacao = topico.dataCriacao,
            respostas = topico.respostas
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter({
                t -> t.id == id
        }).findFirst().orElseThrow{NotFoundException(notFoudMessage)}
        topicos = topicos.minus(topico)
    }
}