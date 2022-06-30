package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import org.springframework.stereotype.Service

@Service
class DeleteAllBooksFromCustomerUseCase(private val repository: IBookRepository,
private val customerRepository: ICustomerRepository) : IDeleteAllBooksFromCustomerUseCase {
   override fun execute(deleteBookCommand: DeleteBookByIdCommand) {
      val customerModel =  customerRepository.findById(deleteBookCommand.id)

       if(!customerModel.isPresent)
        throw Exception()

       val books = repository.findByCustomerModel(customerModel.get())

       books.forEach{
           it.status = BookStatusModel.DELETED
       }
       repository.saveAll(books)
   }
}