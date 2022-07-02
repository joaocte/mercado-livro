package com.mercadolivro.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

data class Purchase (
    var id: Long? = null,

    val customer: Customer,

    val books: List<Book>,

    val nfe: String?,

    val price: BigDecimal,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    val updatedAt: LocalDateTime = LocalDateTime.now()
    )