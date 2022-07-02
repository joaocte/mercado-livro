package com.mercadolivro.application.command

import com.mercadolivro.domain.BookStatus
import java.math.BigDecimal

data class UpdateBookCommand(var id : Long, var name: String, var price: BigDecimal, var status : BookStatus? )