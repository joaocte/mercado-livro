package com.mercadolivro.domain

import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.BadRequestException
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.model.CustomerModel
import java.math.BigDecimal
import javax.persistence.*

data class Book(

    var id: Long?,
    var name: String,
    var price: BigDecimal,
    var customerId: Long? = null
)
{
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.CANCELED || field == BookStatus.DELETED)
                throw BadRequestException(Errors.MLB1003.message.format(field), Errors.MLB1003.code)
            field = value
        }

    constructor(
        id: Long?,
        name: String,
        price: BigDecimal,
        status: BookStatus?,
        customerId: Long?
    )
            : this(id, name, price, customerId) {
        this.status = status
    }
}