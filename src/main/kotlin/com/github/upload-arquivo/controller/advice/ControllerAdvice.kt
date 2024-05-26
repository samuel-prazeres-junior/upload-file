package com.github.`upload-arquivo`.controller.advice

import com.github.`upload-arquivo`.domain.dto.ApiError
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ApiError {
        return ApiError(HttpStatus.BAD_REQUEST, ex.message ?: "Erro na leitura do arquivo")
    }
}