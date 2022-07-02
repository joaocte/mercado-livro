package com.mercadolivro.application.usecase.purchase.createPurchase

import com.mercadolivro.application.command.CreatePurchaseCommand

interface ICreatePurchaseUseCase {
    fun execute(createPurchaseCommand: CreatePurchaseCommand)
}