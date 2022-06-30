package com.mercadolivro.application.usecase.book.createBook

import com.mercadolivro.application.command.CreateBookCommand
import com.mercadolivro.application.response.CreateBookCommandResponse
import com.mercadolivro.domain.BookStatus
import com.mercadolivro.extension.toDomain
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class CreateBookUseCase (var customerRepository: ICustomerRepository, var bookRepository: IBookRepository) :
    ICreateBookUseCase
{
    override fun execute(createBookCommand: CreateBookCommand): CreateBookCommandResponse {

        val customer = customerRepository.findById(createBookCommand.customerId)

        if(customer.isEmpty)
            throw Exception("Customer not found")

        val bookRegistered = bookRepository.existsByNameAndCustomerModel(createBookCommand.name, customer.get())

        if(bookRegistered)
            throw Exception("Book already registered")


        val bookDomain = createBookCommand.toDomain(BookStatus.ATIVO);


        val bookModel = bookDomain.toModel(customer.get())


        val bookSaved = bookRepository.save(bookModel)

        return CreateBookCommandResponse(bookSaved.id!!)

    }

}