package com.mercadolivro.application.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateCustomerRequest(
    @field:NotNull
    @field:NotEmpty
    var name: String,
    @field:Email
    var email: String)