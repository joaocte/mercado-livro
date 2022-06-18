package com.mercadolivro.services

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService : ICustomerService {
    val customers = mutableListOf<CustomerModel>()
    override fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return  customers.filter {
                it.name.contains(name,true)
            }
        }
        return customers
    }

    override fun createCustomer(createCustomerCommand: CreateCustomerCommand) {
        customers.add(CustomerModel(createCustomerCommand.id, createCustomerCommand.name, createCustomerCommand.email))
    }

    override fun getById(getCustomerByIdQuery: GetCustomerByIdQuery): CustomerModel {
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