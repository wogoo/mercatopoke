package com.wogoo.mercatopoke.exception


import com.wogoo.mercatopoke.controller.response.ErrorResponse
import com.wogoo.mercatopoke.controller.response.FieldErrroResponse
import com.wogoo.mercatopoke.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro =  ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.message,
                ex.errorCode,
                null
            )

        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro =  ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.message,
                ex.errorCode,
                null
            )

        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.MP1001.message,
            Errors.MP1001.code,
            ex.bindingResult.fieldErrors.map { FieldErrroResponse(
                it.defaultMessage ?: "Invalid", it.field
            ) }
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }



}