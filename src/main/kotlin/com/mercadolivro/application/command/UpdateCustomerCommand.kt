package com.mercadolivro.application.command

import com.mercadolivro.domain.CustomerStatus
import java.util.UUID

data class UpdateCustomerCommand(var id : Long, var name: String,var email: String, var status : CustomerStatus)