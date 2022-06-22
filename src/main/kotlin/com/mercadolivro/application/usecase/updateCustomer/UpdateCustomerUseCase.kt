package com.mercadolivro.application.usecase.updateCustomer

import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.extension.toCustomerModelInfra
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class UpdateCustomerUseCase(
    private val ICustomerRepository: ICustomerRepository
) : IUpdateCustomerUseCase {
    override fun execute(updateCustomerCommand: UpdateCustomerCommand) {

        val customer = updateCustomerCommand.toCustomerModelInfra();

        var customerNotFound =  ICustomerRepository.existsById(customer.id!!)

        if(!customerNotFound) {
            throw Exception("Customer Not Found")
        }

        ICustomerRepository.save(customer)

    }
}