package com.mercadolivro.application.usecase.getcustomer

import com.mercadolivro.application.query.GetAllCustomersFilter
import com.mercadolivro.domain.Customer

interface IGetAllCustomersUseCase {

    fun execute(getAllCustomersFilter: GetAllCustomersFilter?) : List<Customer>
}