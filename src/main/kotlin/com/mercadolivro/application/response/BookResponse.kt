package com.mercadolivro.application.response

import java.math.BigDecimal

data class BookResponse (
    var id: Long,
    var name: String,
    var price: BigDecimal,
    var status : String,
    var customerId: Long
)