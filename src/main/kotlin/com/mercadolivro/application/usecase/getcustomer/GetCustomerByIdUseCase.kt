package com.mercadolivro.application.usecase.getcustomer

import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.toDomain
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service


@Service
class GetCustomerByIdUseCase (private val ICustomerRepository: ICustomerRepository) : IGetCustomerByIdUseCase
{
    override fun execute(getCustomerByIdQuery: GetCustomerByIdQuery): Customer {
        var customer = ICustomerRepository.findById(getCustomerByIdQuery.id)

        return customer?.get()?.toDomain()
    }
}