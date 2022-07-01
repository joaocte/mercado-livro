package com.mercadolivro.exception

import com.mercadolivro.exception.customException.AlreadyRegisteredException
import com.mercadolivro.exception.customException.BadRequestException
import com.mercadolivro.exception.customException.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex : NotFoundException, request : WebRequest) : ResponseEntity<ExceptionResponse>{
        var response = ExceptionResponse(
            HttpStatus.NOT_FOUND,
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(response, response.status)
    }
    @ExceptionHandler(BadRequestException::class)
    fun handleNotFoundException(ex : BadRequestException, request : WebRequest) : ResponseEntity<ExceptionResponse>{
        var response = ExceptionResponse(
            HttpStatus.BAD_REQUEST,
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(response, response.status)
    }
    @ExceptionHandler(AlreadyRegisteredException::class)
    fun handleNotFoundException(ex : AlreadyRegisteredException, request : WebRequest) : ResponseEntity<ExceptionResponse>{
        var response = ExceptionResponse(
            HttpStatus.CONFLICT,
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(response, response.status)
    }
}