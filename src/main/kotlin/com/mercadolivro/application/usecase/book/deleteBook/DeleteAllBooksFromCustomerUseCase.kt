package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class DeleteAllBooksFromCustomerUseCase(private val repository: IBookRepository,
private val customerRepository: ICustomerRepository) : IDeleteAllBooksFromCustomerUseCase {
   override fun execute(deleteBookCommand: DeleteBookByIdCommand) {
      val customerModel =  customerRepository.findById(deleteBookCommand.id)

       if(!customerModel.isPresent)
        throw NotFoundException(Errors.MLC2000.message, Errors.MLC2000.code)

       val books = repository.findByCustomerModel(customerModel.get())

       books.forEach{
           it.status = BookStatusModel.DELETED
       }
       repository.saveAll(books)
   }
}