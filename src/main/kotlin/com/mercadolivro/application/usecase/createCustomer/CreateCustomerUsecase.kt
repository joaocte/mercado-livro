package com.mercadolivro.application.usecase.createCustomer

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.extension.toCustomerModelInfra
import com.mercadolivro.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CreateCustomerUsecase (private val customerRepository: CustomerRepository) : ICreateCustomerUseCase {

    override fun execute(createCustomerCommand: CreateCustomerCommand) {

        val customer = createCustomerCommand.toCustomerModelInfra();

        var customerAlreadyRegistered =  customerRepository.existsById(customer.id)

        if(customerAlreadyRegistered) {
            throw Exception("Customer Already Registered")
        }

        customerRepository.save(customer)

    }
}