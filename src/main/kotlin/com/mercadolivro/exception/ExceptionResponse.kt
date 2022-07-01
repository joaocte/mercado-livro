package com.mercadolivro.exception

import org.springframework.http.HttpStatus
import org.springframework.validation.AbstractErrors

data class ExceptionResponse (
    var status : HttpStatus,
    var message : String,
    var internalCode : String,
    var errors : List<Notification>?
        )