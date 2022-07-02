package com.mercadolivro.extension

import com.mercadolivro.application.command.CreatePurchaseCommand
import com.mercadolivro.application.request.CreatePurchaseRequest
import com.mercadolivro.domain.Purchase
import com.mercadolivro.infrastructure.model.PurchaseModel

fun CreatePurchaseRequest.toCommand() : CreatePurchaseCommand{
    return CreatePurchaseCommand(this.customerId, this.bookIds)
}

fun Purchase.toModel() : PurchaseModel{
    var customerModel = this.customer.toModel()
    var booksModel = this.books.map { it.toModel(customerModel) }.toMutableList()
    return PurchaseModel(this.id, customerModel, booksModel, this.nfe, this.price, this.createdAt, this.updatedAt)
}