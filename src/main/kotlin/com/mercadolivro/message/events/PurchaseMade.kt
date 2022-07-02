package com.mercadolivro.message.events

import com.mercadolivro.infrastructure.model.PurchaseModel
import org.springframework.context.ApplicationEvent

data class PurchaseMade (
   val publishedBy: Any,
    val purchaseModel: PurchaseModel
    ) : ApplicationEvent(publishedBy)