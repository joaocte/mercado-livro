package com.mercadolivro.application.request

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class CreatePurchaseRequest(
    @field:NotNull
    @field:Positive
    @JsonAlias("customer_id")
    val customerId: Long,

    @field:NotNull
    @field:NotEmpty
    @JsonAlias("book_ids")
    val bookIds: Set<Long>
)
