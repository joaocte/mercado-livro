package com.mercadolivro.application.usecase.createCustomer

import com.mercadolivro.application.command.CreateCustomerCommand

interface ICreateCustomerUseCase {
    fun execute(createCustomerCommand: CreateCustomerCommand)
}