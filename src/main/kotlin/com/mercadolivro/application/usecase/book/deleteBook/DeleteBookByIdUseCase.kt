package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Service

@Service
class DeleteBookByIdUseCase (val repository: IBookRepository) :IDeleteBookByIdUseCase {
    override fun execute(deleteBookCommand: DeleteBookByIdCommand) {
        val book = repository.findById(deleteBookCommand.id)

        if (book.isEmpty)
        throw Exception("Book not found")

        val bookModel = book.get()

        bookModel.status = BookStatusModel.CANCELED

        repository.save(bookModel)
    }
}