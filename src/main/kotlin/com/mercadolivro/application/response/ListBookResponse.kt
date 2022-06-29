package com.mercadolivro.application.response

import com.mercadolivro.domain.BookStatus
import java.math.BigDecimal

data class ListBookResponse (
    var id: Long,
    var name: String,
    var price: BigDecimal,
    var customerId: Long
)