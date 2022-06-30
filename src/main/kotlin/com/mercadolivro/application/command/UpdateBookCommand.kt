package com.mercadolivro.application.command

import java.math.BigDecimal

data class UpdateBookCommand(var id : Long, var name: String, var price: BigDecimal)