package com.mercadolivro.openApi

import com.mercadolivro.application.request.CreatePurchaseRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name = "Purchase", description = "this API provide methods for operations with purchases")
interface IPurchaseController {
    @Operation(summary = "Create a purchase on Mercado Livro")
    fun createPurchase(request: CreatePurchaseRequest)
}