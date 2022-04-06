package br.com.maicon.forum.service

import br.com.maicon.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class CursoService(private var cursos: List<Curso>){
    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programacao"
        )

        val curso2 = Curso(
            id = 2,
            nome = "Java",
            categoria = "Programacao"
        )
        val curso3 = Curso(
            id = 3,
            nome = "SpringBoot",
            categoria = "Programacao"
        )
        val curso4 = Curso(
            id = 4,
            nome = "SqlServer",
            categoria = "Programacao"
        )

        cursos = Arrays.asList(curso,curso2,curso3,curso4)
    }

    fun buscarPorId(idCurso: Long): Curso {
        return cursos.stream().filter({ c ->
            c.id == idCurso
        }).findFirst().get()
    }
}
