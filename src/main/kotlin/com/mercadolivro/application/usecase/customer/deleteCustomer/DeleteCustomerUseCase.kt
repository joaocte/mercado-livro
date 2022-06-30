package com.mercadolivro.application.usecase.customer.deleteCustomer

import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.usecase.book.deleteBook.IDeleteAllBooksFromCustomerUseCase
import com.mercadolivro.extension.toDeleteBookByIdCommand
import com.mercadolivro.extension.toDomain
import com.mercadolivro.infrastructure.model.CustomerStatusModel
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class DeleteCustomerUseCase (private val repository: ICustomerRepository,
                             private val deleteAllBooksFromCustomerUseCase: IDeleteAllBooksFromCustomerUseCase
) : IDeleteCustomerUseCase {
    override fun execute(deleteCustomerByIdCommand: DeleteCustomerByIdCommand) {


        var customerRegistered = repository.findById(deleteCustomerByIdCommand.id)

        if(customerRegistered.isPresent)
            throw Exception("Customer Not Found")

        val customerUpdated = customerRegistered.get()
        customerUpdated.status = CustomerStatusModel.INACTIVE

        repository.save(customerUpdated)

        deleteAllBooksFromCustomerUseCase.execute(customerUpdated.id!!.toDeleteBookByIdCommand())
    }
}