package com.mercadolivro.application.usecase.deleteCustomer

import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.extension.toCustomerModelInfra
import com.mercadolivro.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class DeleteCustomerUseCase (private val customerRepository: CustomerRepository) : IDeleteCustomerUseCase {
    override fun execute(deleteCustomerByIdCommand: DeleteCustomerByIdCommand) {


        var customerRegistered = customerRepository.existsById(deleteCustomerByIdCommand.id)

        if(!customerRegistered)
            throw Exception("Customer Not Found")

        customerRepository.deleteById(deleteCustomerByIdCommand.id)

    }
}