package com.mercadolivro.application.usecase.book.updateBook

import com.mercadolivro.application.command.UpdateBookCommand
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.repository.IBookRepository

class UpdateBookUseCase(private val repository: IBookRepository) : IUpdateBookUseCase {
    override fun execute(updateBookCommand: UpdateBookCommand)
    {
        val book = repository.findById(updateBookCommand.id)

        if(book.isEmpty)
            throw Exception("Book not found")

        var updatedBookModel = updateBookCommand.toModel(book.get())

        repository.save(updatedBookModel)
    }
}