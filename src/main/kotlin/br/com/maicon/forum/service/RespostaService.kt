package br.com.maicon.forum.service

import br.com.maicon.forum.dto.NovaRespostaForm
import br.com.maicon.forum.dto.RespostaView
import br.com.maicon.forum.mapper.RespostaViewMapper
import br.com.maicon.forum.mapper.RespostasFormMapper
import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Resposta
import br.com.maicon.forum.model.Topico
import br.com.maicon.forum.model.Usuario
import br.com.maicon.forum.repository.RespostaRepository
import br.com.maicon.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class RespostaService(
    private var repository: RespostaRepository,
    private val respostaViewMapper: RespostaViewMapper,
    private val respostasFormMapper: RespostasFormMapper
    ) {

    fun listar(): List<RespostaView> {
        return repository.findAll().stream().map { r -> respostaViewMapper.map(r)}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): RespostaView{
      val resposta = repository.getById(id)
        return respostaViewMapper.map(resposta)
    }

    fun cadastrar(form: NovaRespostaForm) {
          val resposta = respostasFormMapper.map(form)
          repository.save(resposta)
    }
}