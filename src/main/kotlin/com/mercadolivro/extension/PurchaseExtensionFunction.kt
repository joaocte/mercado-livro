package com.mercadolivro.extension

import com.mercadolivro.application.command.CreatePurchaseCommand
import com.mercadolivro.application.request.CreatePurchaseRequest

fun CreatePurchaseRequest.toCommand() : CreatePurchaseCommand{
    return CreatePurchaseCommand(this.customerId, this.bookIds)
}