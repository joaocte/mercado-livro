package com.mercadolivro.exception.customException

class AlreadyRegisteredException(override val message: String, var errorCode : String)  :Exception() {
}