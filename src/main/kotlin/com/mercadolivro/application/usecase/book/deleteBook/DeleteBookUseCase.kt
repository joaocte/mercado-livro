package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Service

@Service
class DeleteBookUseCase (val repository: IBookRepository) :IDeleteBookUseCase {
    override fun execute(deleteBookCommand: DeleteBookByIdCommand) {
        val bookExists = repository.existsById(deleteBookCommand.id)

        if (!bookExists)
        throw Exception("Book not found")

        repository.deleteById(deleteBookCommand.id)
    }
}