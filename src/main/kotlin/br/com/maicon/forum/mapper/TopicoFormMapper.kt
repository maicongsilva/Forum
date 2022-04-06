package br.com.maicon.forum.mapper

import br.com.maicon.forum.dto.NovoTopicoForm
import br.com.maicon.forum.model.Topico
import br.com.maicon.forum.service.CursoService
import br.com.maicon.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
  ): Mapper<NovoTopicoForm, Topico>{
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}
