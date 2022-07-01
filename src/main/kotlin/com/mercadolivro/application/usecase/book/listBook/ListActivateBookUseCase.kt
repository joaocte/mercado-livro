package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.extension.toBookResponse
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ListActivateBookUseCase(val repository: IBookRepository) : IListActivateBookUseCase {
    override fun execute(pageble: Pageable): Page<BookResponse> {
        var books = repository.findByStatus(BookStatusModel.ACTIVE, pageble)

        if(books.isEmpty())
            throw Exception("no active books found")

       return books.map { it.toBookResponse() }
    }
}