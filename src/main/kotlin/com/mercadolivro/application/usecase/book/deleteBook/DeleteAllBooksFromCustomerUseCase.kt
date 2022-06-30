package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository

class DeleteAllBooksFromCustomerUseCase(private val repository: IBookRepository) : IDeleteAllBooksFromCustomerUseCase {
   override fun execute(customer: Customer) {
      val books =  repository.findByCustomerModel(customer.toModel())

       books.forEach{
           it.status = BookStatusModel.DELETED
       }
       repository.saveAll(books)
   }
}