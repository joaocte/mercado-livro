package com.mercadolivro.domain

import java.math.BigDecimal
import javax.persistence.*

data class Book(

    var id: Long?,
    var name: String,
    var price: BigDecimal,
    var status: BookStatus? = null,
    var customerId: Long? = null
)