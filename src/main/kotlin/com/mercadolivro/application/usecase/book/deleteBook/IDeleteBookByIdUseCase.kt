package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand

interface IDeleteBookByIdUseCase {
fun execute(deleteBookCommand : DeleteBookByIdCommand)
}