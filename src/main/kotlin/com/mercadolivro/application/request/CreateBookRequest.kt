package com.mercadolivro.application.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class CreateBookRequest (
    var name: String,
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId : Long
    )