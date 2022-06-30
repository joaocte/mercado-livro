package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.domain.Customer

interface IDeleteAllBooksFromCustomerUseCase {
    fun execute(customer: Customer)
}