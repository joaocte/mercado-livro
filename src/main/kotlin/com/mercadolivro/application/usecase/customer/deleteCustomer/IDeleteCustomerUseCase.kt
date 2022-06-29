package com.mercadolivro.application.usecase.customer.deleteCustomer

import com.mercadolivro.application.command.DeleteCustomerByIdCommand

interface IDeleteCustomerUseCase {
    fun execute (deleteCustomerByIdCommand: DeleteCustomerByIdCommand)
}