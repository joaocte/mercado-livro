package com.mercadolivro.application.command

data class UpdateCustomerCommand(var id : Long, var name: String,var email: String)