package com.mercadolivro.application.usecase.customer.getcustomer

import com.mercadolivro.application.query.customer.GetAllCustomersFilter
import com.mercadolivro.application.response.CustomerResponse
import com.mercadolivro.extension.toCustomerResponse
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class GetAllCustomersUseCase(private val ICustomerRepository: ICustomerRepository) : IGetAllCustomersUseCase {



    override fun execute(getAllCustomersFilter: GetAllCustomersFilter?, pageble: Pageable): Page<CustomerResponse> {

        getAllCustomersFilter?.name?.let{
            var name = getAllCustomersFilter.name
         return ICustomerRepository.findByNameContaining(name, pageble).map { it.toCustomerResponse() }
        }
        return ICustomerRepository.findAll(pageble).map { it.toCustomerResponse() }
    }
}