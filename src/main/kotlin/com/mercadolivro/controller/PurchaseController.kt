package com.mercadolivro.controller

import com.mercadolivro.application.request.CreatePurchaseRequest
import com.mercadolivro.application.usecase.purchase.createPurchase.ICreatePurchaseUseCase
import com.mercadolivro.extension.toCommand
import com.mercadolivro.openApi.IPurchaseController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("purchase")
class PurchaseController (private val createPurchaseUseCase: ICreatePurchaseUseCase
                           )  : IPurchaseController{

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun createPurchase(request: CreatePurchaseRequest) {
        createPurchaseUseCase.execute(request.toCommand())
    }

}

