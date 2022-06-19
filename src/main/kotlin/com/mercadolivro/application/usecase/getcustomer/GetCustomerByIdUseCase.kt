package com.mercadolivro.application.usecase.getcustomer

import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.toDomain
import com.mercadolivro.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class GetCustomerByIdUseCase (private val customerRepository: CustomerRepository) : IGetCustomerByIdUseCase
{
    override fun execute(getCustomerByIdQuery: GetCustomerByIdQuery): Customer {
        var customer = customerRepository.findById(getCustomerByIdQuery.id)

        return customer?.get()?.toDomain()
    }
}