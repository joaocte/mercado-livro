package com.mercadolivro.application.command

import com.mercadolivro.domain.BookStatus
import java.math.BigDecimal

data class CreateBookCommand(
    var name: String,
    var price: BigDecimal,
    var customerId : Long,
    val status: BookStatus = BookStatus.ACTIVE
)