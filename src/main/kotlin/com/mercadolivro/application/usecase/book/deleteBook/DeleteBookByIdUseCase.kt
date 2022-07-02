package com.mercadolivro.application.usecase.book.deleteBook

import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class DeleteBookByIdUseCase (val repository: IBookRepository) :IDeleteBookByIdUseCase {
    override fun execute(deleteBookCommand: DeleteBookByIdCommand) {
        val book = repository.findById(deleteBookCommand.id)

        if (book.isEmpty)
        throw NotFoundException(Errors.MLB1000.message.format(deleteBookCommand.id), Errors.MLB1000.code)

        val bookModel = book.get()

        bookModel.status = BookStatusModel.CANCELED

        repository.save(bookModel)
    }
}