package com.mercadolivro.application.usecase.customer.getcustomer

import com.mercadolivro.application.query.GetAllCustomersFilter
import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.toDomain
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class GetAllCustomersUseCase(private val ICustomerRepository: ICustomerRepository) : IGetAllCustomersUseCase {



    override fun execute(getAllCustomersFilter: GetAllCustomersFilter?): List<Customer> {

        getAllCustomersFilter?.name?.let{
            var name = getAllCustomersFilter.name
         return ICustomerRepository.findByNameContaining(name).map { it.toDomain() }
        }
        return ICustomerRepository.findAll().map { it.toDomain() }
    }
}