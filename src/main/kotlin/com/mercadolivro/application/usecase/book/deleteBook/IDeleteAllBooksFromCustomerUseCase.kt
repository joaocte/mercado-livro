package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.domain.Customer

interface IDeleteAllBooksFromCustomerUseCase {
    fun execute(deleteBookCommand: DeleteBookByIdCommand)
}