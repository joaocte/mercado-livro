package com.mercadolivro.application.usecase.customer.getcustomer

import com.mercadolivro.application.query.customer.GetCustomerByIdQuery
import com.mercadolivro.domain.Customer

interface IGetCustomerByIdUseCase {
    fun execute(getCustomerByIdQuery: GetCustomerByIdQuery) : Customer
}