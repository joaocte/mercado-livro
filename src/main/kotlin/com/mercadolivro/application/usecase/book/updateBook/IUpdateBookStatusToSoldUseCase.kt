package com.mercadolivro.application.usecase.book.updateBook

import com.mercadolivro.message.events.PurchaseMade

interface IUpdateBookStatusToSoldUseCase {
    fun execute(purchaseMade: PurchaseMade)
}