package com.mercadolivro.application.usecase.getcustomer

import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.domain.CustomerModel

interface IGetCustomerByIdUseCase {
    fun execute(getCustomerByIdQuery: GetCustomerByIdQuery) : CustomerModel
}