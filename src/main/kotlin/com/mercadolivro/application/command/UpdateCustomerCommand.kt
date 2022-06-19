package com.mercadolivro.application.command

import java.util.UUID

data class UpdateCustomerCommand(var id : Long, var name: String,var email: String)