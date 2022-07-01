package com.mercadolivro.exception.customException

class BadRequestException(override val message: String, var errorCode : String) : Exception() {
}