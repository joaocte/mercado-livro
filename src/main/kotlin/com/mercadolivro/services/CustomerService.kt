package com.mercadolivro.services

import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.domain.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService(
) : ICustomerService {
    val customers = mutableListOf<Customer>()
    override fun getAll(name: String?): List<Customer> {
        name?.let {
            return  customers.filter {
                it.name.contains(name,true)
            }
        }
        return customers
    }


    override fun getById(getCustomerByIdQuery: GetCustomerByIdQuery): Customer {
        return customers.first{it.id ==getCustomerByIdQuery.id}
    }

    override fun updateCustomer( updateCustomerCommand: UpdateCustomerCommand) {
        return customers.first{it.id == updateCustomerCommand.id}.let {
            it.name = updateCustomerCommand.name
            it.email = updateCustomerCommand.email
        }
    }

    override fun deleteCustomer(deleteCustomerByIdCommand: DeleteCustomerByIdCommand) {
        customers.removeIf{it.id == deleteCustomerByIdCommand.id}
    }
}