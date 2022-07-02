package com.mercadolivro.openApi

import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.application.response.CustomerResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
@Tag(name = "Customer", description = "this API provide methods for operations with customers")
interface ICustomersController {

    @Operation(summary = "Find all customers, also find all containing a string on name")
    fun getAll(name: String?, pageble: Pageable): Page<CustomerResponse>

    @Operation(summary = "Create new customer")
    fun createCustomer(createCustomerRequest: CreateCustomerRequest)

    @Operation(summary = "Find a customer by id")
    fun getById(id: Long): CustomerResponse

    @Operation(summary = "Update existing customer")
    fun updateCustomer(id: Long,updateCustomerRequest: UpdateCustomerRequest)

    @Operation(summary = "Delete a customer by id")
    fun deleteCustomer( id: Long)
}