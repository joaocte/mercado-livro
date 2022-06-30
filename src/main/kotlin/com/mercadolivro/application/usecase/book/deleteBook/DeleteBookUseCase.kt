package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Service

@Service
class DeleteBookUseCase (val repository: IBookRepository) :IDeleteBookUseCase {
    override fun execute(deleteBookCommand: DeleteBookByIdCommand) {
        val book = repository.findById(deleteBookCommand.id)

        if (book.isEmpty)
        throw Exception("Book not found")

        val bookModel = book.get()

        bookModel.status = BookStatusModel.CANCELADO

        repository.save(bookModel)
    }
}