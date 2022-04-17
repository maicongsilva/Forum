package br.com.maicon.forum.exception

import br.com.maicon.forum.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun  handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath

        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun  handleValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorView {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach{
            e -> errorMessage.put(e.field, e.defaultMessage)
        }
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = request.servletPath

        )
    }
}