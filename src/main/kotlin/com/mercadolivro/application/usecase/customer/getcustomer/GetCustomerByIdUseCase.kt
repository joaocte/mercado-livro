package com.mercadolivro.application.usecase.customer.getcustomer

import com.mercadolivro.application.query.customer.GetCustomerByIdQuery
import com.mercadolivro.application.response.CustomerResponse
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.extension.toCustomerResponse
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service


@Component
class GetCustomerByIdUseCase (private val ICustomerRepository: ICustomerRepository) : IGetCustomerByIdUseCase
{
    override fun execute(getCustomerByIdQuery: GetCustomerByIdQuery): CustomerResponse {
        var customer = ICustomerRepository.findById(getCustomerByIdQuery.id)

        if(!customer.isPresent)
            throw NotFoundException(Errors.MLC2000.message.format(getCustomerByIdQuery.id), Errors.MLC2000.code)
        return customer.get().toCustomerResponse()
    }
}