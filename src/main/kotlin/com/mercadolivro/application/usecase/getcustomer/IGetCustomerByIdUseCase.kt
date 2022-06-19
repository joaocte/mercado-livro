package com.mercadolivro.application.usecase.getcustomer

import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.domain.Customer

interface IGetCustomerByIdUseCase {
    fun execute(getCustomerByIdQuery: GetCustomerByIdQuery) : Customer
}