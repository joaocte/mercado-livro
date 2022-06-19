package com.mercadolivro.application.usecase.updateCustomer

import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.extension.toCustomerModelInfra
import com.mercadolivro.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class UpdateCustomerUseCase(
    private val customerRepository: CustomerRepository
) : IUpdateCustomerUseCase {
    override fun execute(updateCustomerCommand: UpdateCustomerCommand) {

        val customer = updateCustomerCommand.toCustomerModelInfra();

        var customerNotFound =  customerRepository.existsById(customer.id!!)

        if(!customerNotFound) {
            throw Exception("Customer Not Found")
        }

        customerRepository.save(customer)

    }
}