package com.mercadolivro.exception.customException

class NotFoundException(override val message: String, var errorCode : String) : Exception() {
}