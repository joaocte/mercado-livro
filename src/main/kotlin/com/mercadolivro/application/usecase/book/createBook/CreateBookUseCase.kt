package com.mercadolivro.application.usecase.book.createBook

import com.mercadolivro.application.command.CreateBookCommand
import com.mercadolivro.application.response.CreateBookCommandResponse
import com.mercadolivro.domain.BookStatus
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.AlreadyRegisteredException
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.extension.toDomain
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class CreateBookUseCase (var customerRepository: ICustomerRepository, var bookRepository: IBookRepository) :
    ICreateBookUseCase
{
    override fun execute(createBookCommand: CreateBookCommand): CreateBookCommandResponse {

        val customer = customerRepository.findById(createBookCommand.customerId)

        if(!customer.isPresent)
            throw NotFoundException(Errors.MLC2000.message.format(createBookCommand.customerId), Errors.MLC2000.code)

        val bookRegistered = bookRepository.existsByNameAndCustomerModel(createBookCommand.name, customer.get())

        if(bookRegistered)
           throw AlreadyRegisteredException(Errors.MLB1002.message, Errors.MLB1002.code)


        val bookDomain = createBookCommand.toDomain(BookStatus.ACTIVE);


        val bookModel = bookDomain.toModel(customer.get())


        val bookSaved = bookRepository.save(bookModel)

        return CreateBookCommandResponse(bookSaved.id!!)

    }

}