import br.com.maicon.forum.dto.NovaRespostaForm
import br.com.maicon.forum.dto.RespostaView
import br.com.maicon.forum.service.RespostaService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos/respostas/{id}")
class RespostasController(private val service: RespostaService) {

    @GetMapping
    fun buscarPorId(@PathVariable id: Long): RespostaView {
        return service.buscarPorId(id)
    }

    @GetMapping()
    fun listar(): List<RespostaView>{
        return service.listar()
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovaRespostaForm){
        service.cadastrar(dto)
    }
}