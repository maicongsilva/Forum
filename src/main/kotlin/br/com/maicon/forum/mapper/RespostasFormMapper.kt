package br.com.maicon.forum.mapper

import br.com.maicon.forum.dto.NovaRespostaForm
import br.com.maicon.forum.model.Resposta
import br.com.maicon.forum.model.Topico
import br.com.maicon.forum.service.TopicoService
import br.com.maicon.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostasFormMapper(
    private val usuarioService: UsuarioService,
    private val topicoService: TopicoService
):Mapper<NovaRespostaForm, Resposta>{
    override fun map(t: NovaRespostaForm): Resposta {
        return Resposta(
            mensagem = t.mensagem,
            autor = usuarioService.buscarPorId(t.idAutor),
            topico = topicoService.buscarTopicoPorId(t.idTopico)
        )
    }
}
