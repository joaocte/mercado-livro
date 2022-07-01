package com.mercadolivro.application.usecase.customer.createCustomer

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.AlreadyRegisteredException
import com.mercadolivro.extension.toCustomerModelInfra
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class CreateCustomerUsecase (private val ICustomerRepository: ICustomerRepository) : ICreateCustomerUseCase {

    override fun execute(createCustomerCommand: CreateCustomerCommand) {

        val customer = createCustomerCommand.toCustomerModelInfra();

        var customerAlreadyRegistered = ICustomerRepository.existsByEmail(createCustomerCommand.email)

        if(customerAlreadyRegistered)
             throw AlreadyRegisteredException(Errors.MLC2001.message.format(createCustomerCommand.email), Errors.MLC2001.code)

        ICustomerRepository.save(customer)

    }
}