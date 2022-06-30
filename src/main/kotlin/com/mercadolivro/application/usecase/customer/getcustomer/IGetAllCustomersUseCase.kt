package com.mercadolivro.application.usecase.customer.getcustomer

import com.mercadolivro.application.query.customer.GetAllCustomersFilter
import com.mercadolivro.domain.Customer

interface IGetAllCustomersUseCase {

    fun execute(getAllCustomersFilter: GetAllCustomersFilter?) : List<Customer>
}