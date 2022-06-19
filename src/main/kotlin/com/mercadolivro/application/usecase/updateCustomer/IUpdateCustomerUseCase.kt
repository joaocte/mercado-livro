package com.mercadolivro.application.usecase.updateCustomer

import com.mercadolivro.application.command.UpdateCustomerCommand

interface IUpdateCustomerUseCase {
    fun execute(updateCustomerCommand: UpdateCustomerCommand)
}