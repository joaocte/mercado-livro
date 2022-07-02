package com.mercadolivro.application.usecase.book.updateBook

import com.mercadolivro.application.command.UpdateBookCommand
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class UpdateBookUseCase(private val repository: IBookRepository) : IUpdateBookUseCase {
    override fun execute(updateBookCommand: UpdateBookCommand)
    {
        val book = repository.findById(updateBookCommand.id)

        if(!book.isPresent)
            throw NotFoundException(Errors.MLB1000.message.format(updateBookCommand.id), Errors.MLB1000.code)

        var updatedBookModel = updateBookCommand.toModel(book.get())

        repository.save(updatedBookModel)
    }
}