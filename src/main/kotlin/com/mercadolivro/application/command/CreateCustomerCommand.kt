package com.mercadolivro.application.command

import java.util.*

data class CreateCustomerCommand(var id : UUID, var name: String, var email: String)