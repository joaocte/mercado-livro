package com.mercadolivro.application.usecase.purchase.generateNfe

import com.mercadolivro.infrastructure.repository.IPurchaseRepository
import com.mercadolivro.message.events.PurchaseMade
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeUseCase(
    private val repository : IPurchaseRepository
) : IGenerateNfeUseCase {

    @Async
    @EventListener
    override fun execute(pushaseMade: PurchaseMade) {
        val pushaseModel = pushaseMade.purchaseModel.copy(nfe = UUID.randomUUID().toString())
        repository.save(pushaseModel)
    }
}