package com.mercadolivro.application.usecase.getcustomer

import com.mercadolivro.application.query.GetAllCustomersFilter
import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.toDomain
import com.mercadolivro.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class GetAllCustomersUseCase(private val customerRepository: CustomerRepository) : IGetAllCustomersUseCase {



    override fun execute(getAllCustomersFilter: GetAllCustomersFilter?): List<Customer> {

        getAllCustomersFilter?.name?.let{
            var name = getAllCustomersFilter.name
         return customerRepository.findByNameContaining(name).map { it.toDomain() }
        }
        return customerRepository.findAll().map { it.toDomain() }
    }
}