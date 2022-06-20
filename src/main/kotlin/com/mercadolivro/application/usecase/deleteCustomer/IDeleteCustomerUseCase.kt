package com.mercadolivro.application.usecase.deleteCustomer

import com.mercadolivro.application.command.DeleteCustomerByIdCommand

interface IDeleteCustomerUseCase {
    fun execute (deleteCustomerByIdCommand: DeleteCustomerByIdCommand)
}