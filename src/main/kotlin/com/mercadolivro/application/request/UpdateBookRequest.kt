package com.mercadolivro.application.request

import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateBookRequest(
    @field:NotEmpty
    @field:NotNull
    var name: String,

    @field:NotNull
    @field:NotBlank
    var price: BigDecimal)