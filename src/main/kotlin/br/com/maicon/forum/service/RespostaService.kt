package br.com.maicon.forum.service

import br.com.maicon.forum.dto.NovaRespostaForm
import br.com.maicon.forum.mapper.RespostasFormMapper
import br.com.maicon.forum.model.Curso
import br.com.maicon.forum.model.Resposta
import br.com.maicon.forum.model.Topico
import br.com.maicon.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class RespostaService(
    private var respostas: List<Resposta>,
    private val respostasFormMapper: RespostasFormMapper,
    private val topicoService: TopicoService
    ) {

    init{
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programacao"
        )
        val autor = Usuario(
            id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com"
        )
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = curso,
            autor = autor
        )

        val resposta1 = Resposta(
            id = 1,
            mensagem = "Resposta 1",
            autor = autor,
            topico = topico,
            solucao = false
        )

        val resposta2 = Resposta(
            id = 2,
            mensagem = "Resposta 2",
            autor = autor,
            topico = topico,
            solucao = false
        )

        respostas = Arrays.asList(resposta1, resposta2)
    }

    fun listar(idTopico: Long): List<Resposta> {
        return respostas.stream().filter{ r ->
            r.topico.id == idTopico
        }.collect(Collectors.toList())
    }

    fun cadastrar(form: NovaRespostaForm) {
          val resposta = respostasFormMapper.map(form)
              resposta.id = respostas.size.toLong()+1
              respostas = respostas.plus(resposta)
    }
}