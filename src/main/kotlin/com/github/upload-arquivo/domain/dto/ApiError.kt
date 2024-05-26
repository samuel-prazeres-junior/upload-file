package com.github.`upload-arquivo`.domain.dto

import org.springframework.http.HttpStatus

data class ApiError (
    val status: HttpStatus,
    val message: String
)