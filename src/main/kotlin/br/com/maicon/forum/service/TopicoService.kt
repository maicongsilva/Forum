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
import br.com.maicon.forum.repository.CurosRepository
import br.com.maicon.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoudMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<TopicoView>{
        return repository.findAll().stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
       val topico = repository.findById(id).orElseThrow{NotFoundException(notFoudMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView{
       val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView{
        val topico = repository.findById(form.id).orElseThrow{NotFoundException(notFoudMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}