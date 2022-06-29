package com.mercadolivro.application.usecase.customer.updateCustomer

import com.mercadolivro.application.command.UpdateCustomerCommand

interface IUpdateCustomerUseCase {
    fun execute(updateCustomerCommand: UpdateCustomerCommand)
}