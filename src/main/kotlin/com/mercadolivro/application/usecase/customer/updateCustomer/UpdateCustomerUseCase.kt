package com.mercadolivro.application.usecase.customer.updateCustomer

import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.extension.toCustomerModelInfra
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class UpdateCustomerUseCase(
    private val ICustomerRepository: ICustomerRepository
) : IUpdateCustomerUseCase {
    override fun execute(updateCustomerCommand: UpdateCustomerCommand) {

        val customerModel =  ICustomerRepository.findById(updateCustomerCommand.id)

        if(!customerModel.isPresent)
            throw Exception("Customer Not Found")

        val customer = updateCustomerCommand.toCustomerModelInfra(customerModel.get());

        ICustomerRepository.save(customer)

    }
}