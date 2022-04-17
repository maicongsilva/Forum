package br.com.maicon.forum.mapper

import br.com.maicon.forum.dto.NovaRespostaForm
import br.com.maicon.forum.model.Resposta
import br.com.maicon.forum.repository.TopicoRepository
import br.com.maicon.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostasFormMapper(
    private val usuarioService: UsuarioService,
    private val topicoRepository: TopicoRepository
):Mapper<NovaRespostaForm, Resposta>{
    override fun map(t: NovaRespostaForm): Resposta {
        return Resposta(
            mensagem = t.mensagem,
            autor = usuarioService.buscarPorId(t.idAutor),
            topico = topicoRepository.getById(t.idTopico)
        )
    }
}
