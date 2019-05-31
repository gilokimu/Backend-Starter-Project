package me.gilo.backend.delivery.rest.imp

import me.gilo.backend.delivery.rest.api.ErrorCodeDto
import me.gilo.backend.delivery.rest.api.ErrorDto
import me.gilo.backend.delivery.usecases.core.exceptions.NotFoundException
import me.gilo.backend.delivery.usecases.core.exceptions.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(NotFoundException::class)
    fun notFound(ex: NotFoundException) =
        ResponseEntity(ErrorDto(ErrorCodeDto.NOT_FOUND, "Resource not found"), HttpStatus.NOT_FOUND)

    @ExceptionHandler(ValidationException::class)
    fun alreadyExists(ex: ValidationException) =
        ResponseEntity(ErrorDto(ErrorCodeDto.VALIDATION_ERROR, ex.message), HttpStatus.BAD_REQUEST)
}
