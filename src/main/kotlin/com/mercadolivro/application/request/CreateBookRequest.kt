package com.mercadolivro.application.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateBookRequest (
    @field:NotNull
    @field:NotEmpty
    var name: String,
    @field:NotNull
    var price: BigDecimal,
    @field:NotNull
    @JsonAlias("customer_id")
    var customerId : Long
    )