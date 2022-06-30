package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand

interface IDeleteBookUseCase {
fun execute(deleteBookCommand : DeleteBookByIdCommand)
}