package com.mercadolivro.application.request

import java.math.BigDecimal

data class UpdateBookRequest(var name: String, var price: BigDecimal)