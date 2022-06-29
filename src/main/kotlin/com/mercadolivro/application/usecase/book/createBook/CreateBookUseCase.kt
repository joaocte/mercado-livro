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

        var customer = customerRepository.findById(createBookCommand.customerId!!).get()
            ?: throw Exception ("Customer not found!")

        var bookRegistered = bookRepository.existsByNameAndCustomerId(createBookCommand.name, createBookCommand.customerId)

        if(bookRegistered)
            throw Exception("Book already registered")


        var bookDomain = createBookCommand.toDomain(BookStatus.ATIVO);


        var bookModel = bookDomain.toModel(customer)


        var bookSaved = bookRepository.save(bookModel)

        return CreateBookCommandResponse(bookSaved.id!!)

    }

}