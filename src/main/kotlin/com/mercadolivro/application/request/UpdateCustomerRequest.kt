package com.mercadolivro.application.request

import com.mercadolivro.domain.CustomerStatus
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateCustomerRequest(
    @field:NotNull
    @field: NotEmpty
    var name: String,
    @field:Email
    var email: String)