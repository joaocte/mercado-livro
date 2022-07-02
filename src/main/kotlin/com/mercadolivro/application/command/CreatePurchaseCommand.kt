package com.mercadolivro.application.command

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class CreatePurchaseCommand(
    val customerId: Long,
    val bookIds: Set<Long>
)
