package com.mercadolivro.application.usecase.createCustomer

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.extension.toCustomerModelInfra
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class CreateCustomerUsecase (private val ICustomerRepository: ICustomerRepository) : ICreateCustomerUseCase {

    override fun execute(createCustomerCommand: CreateCustomerCommand) {

        val customer = createCustomerCommand.toCustomerModelInfra();

        var customerAlreadyRegistered = ICustomerRepository.existsByEmail(createCustomerCommand.email)

        if(customerAlreadyRegistered)
             throw Exception("E-mail Already Registered")

        ICustomerRepository.save(customer)

    }
}