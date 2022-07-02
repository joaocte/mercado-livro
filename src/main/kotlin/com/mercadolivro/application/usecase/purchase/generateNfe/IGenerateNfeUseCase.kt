package com.mercadolivro.application.usecase.purchase.generateNfe

import com.mercadolivro.message.events.PurchaseMade
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async

interface IGenerateNfeUseCase {
    @Async
    @EventListener
    fun execute(pushaseMade: PurchaseMade)
}