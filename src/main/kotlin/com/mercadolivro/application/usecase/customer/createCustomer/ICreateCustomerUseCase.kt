package com.mercadolivro.application.usecase.customer.createCustomer

import com.mercadolivro.application.command.CreateCustomerCommand

interface ICreateCustomerUseCase {
    fun execute(createCustomerCommand: CreateCustomerCommand)
}