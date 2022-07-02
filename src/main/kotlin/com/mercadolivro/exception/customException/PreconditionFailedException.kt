package com.mercadolivro.exception.customException

class PreconditionFailedException(override val message: String, var errorCode : String) : Exception() {
}