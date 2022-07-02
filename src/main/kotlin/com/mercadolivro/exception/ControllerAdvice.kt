package com.mercadolivro.exception

import com.mercadolivro.exception.customException.AlreadyRegisteredException
import com.mercadolivro.exception.customException.BadRequestException
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.exception.customException.PreconditionFailedException
import com.mercadolivro.extension.toNotificationResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleNotFoundException(ex : MethodArgumentNotValidException, request : WebRequest) : ResponseEntity<ExceptionResponse>{
        var response = ExceptionResponse(
            HttpStatus.UNPROCESSABLE_ENTITY,
            Errors.MLA0001.message,
            Errors.MLA0001.code,
            ex.bindingResult.fieldErrors.map{ it.toNotificationResponse()}
        )
        return ResponseEntity(response, response.status)
    }
    @ExceptionHandler(PreconditionFailedException::class)
    fun handleNotFoundException(ex : PreconditionFailedException, request : WebRequest) : ResponseEntity<ExceptionResponse>{
        var response = ExceptionResponse(
            HttpStatus.PRECONDITION_FAILED,
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(response, response.status)
    }
}


