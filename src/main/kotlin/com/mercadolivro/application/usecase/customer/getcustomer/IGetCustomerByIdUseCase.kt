package com.mercadolivro.application.usecase.customer.getcustomer

import com.mercadolivro.application.query.customer.GetCustomerByIdQuery
import com.mercadolivro.application.response.CustomerResponse
import com.mercadolivro.domain.Customer

interface IGetCustomerByIdUseCase {
    fun execute(getCustomerByIdQuery: GetCustomerByIdQuery) : CustomerResponse
}