package com.mercadolivro.services

import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.domain.Customer

public interface ICustomerService {

    fun getAll(name: String?): List<Customer>

    fun getById(getCustomerByIdQuery: GetCustomerByIdQuery): Customer

    fun updateCustomer(updateCustomerCommand: UpdateCustomerCommand)

    fun deleteCustomer(deleteCustomerByIdCommand: DeleteCustomerByIdCommand)
}