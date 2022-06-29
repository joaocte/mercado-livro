package com.mercadolivro.application.usecase.customer.deleteCustomer

import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class DeleteCustomerUseCase (private val ICustomerRepository: ICustomerRepository) : IDeleteCustomerUseCase {
    override fun execute(deleteCustomerByIdCommand: DeleteCustomerByIdCommand) {


        var customerRegistered = ICustomerRepository.existsById(deleteCustomerByIdCommand.id)

        if(!customerRegistered)
            throw Exception("Customer Not Found")

        ICustomerRepository.deleteById(deleteCustomerByIdCommand.id)

    }
}