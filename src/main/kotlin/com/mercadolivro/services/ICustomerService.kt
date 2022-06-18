package com.mercadolivro.services

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.model.CustomerModel
import java.util.*

public interface ICustomerService {

    fun getAll(name: String?): List<CustomerModel>

    fun createCustomer(createCustomerCommand: CreateCustomerCommand)

    fun getById(getCustomerByIdQuery: GetCustomerByIdQuery): CustomerModel

    fun updateCustomer(updateCustomerCommand: UpdateCustomerCommand)

    fun deleteCustomer(deleteCustomerByIdCommand: DeleteCustomerByIdCommand)
}