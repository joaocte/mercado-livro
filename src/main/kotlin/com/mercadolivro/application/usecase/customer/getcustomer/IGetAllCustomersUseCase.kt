package com.mercadolivro.application.usecase.customer.getcustomer

import com.mercadolivro.application.query.customer.GetAllCustomersFilter
import com.mercadolivro.application.response.CustomerResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IGetAllCustomersUseCase {

    fun execute(getAllCustomersFilter: GetAllCustomersFilter?, pageble: Pageable) : Page<CustomerResponse>
}