package com.mercadolivro.services

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.domain.CustomerModel

public interface ICustomerService {

    fun getAll(name: String?): List<CustomerModel>

    fun getById(getCustomerByIdQuery: GetCustomerByIdQuery): CustomerModel

    fun updateCustomer(updateCustomerCommand: UpdateCustomerCommand)

    fun deleteCustomer(deleteCustomerByIdCommand: DeleteCustomerByIdCommand)
}