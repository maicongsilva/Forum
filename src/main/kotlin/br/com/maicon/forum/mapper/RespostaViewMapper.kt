package br.com.maicon.forum.mapper

import br.com.maicon.forum.dto.RespostaView
import br.com.maicon.forum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper: Mapper<Resposta, RespostaView>  {
    override fun map(t: Resposta): RespostaView {
       return RespostaView(
            id = t.id,
            autor = t.autor.nome,
            topico = t.topico.titulo,
            message = t.mensagem
        )
    }

}