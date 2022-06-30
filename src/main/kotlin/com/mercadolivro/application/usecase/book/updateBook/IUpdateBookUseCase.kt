package com.mercadolivro.application.usecase.book.updateBook

import com.mercadolivro.application.command.UpdateBookCommand

interface IUpdateBookUseCase {
    fun execute(updateBookCommand: UpdateBookCommand)
}