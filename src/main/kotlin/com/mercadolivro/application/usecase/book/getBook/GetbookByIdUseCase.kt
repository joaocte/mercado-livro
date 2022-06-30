package com.mercadolivro.application.usecase.book.getBook

import com.mercadolivro.application.query.book.GetBookByIdQuery
import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.extension.toBookResponse
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Service

@Service
class GetbookByIdUseCase (val repository: IBookRepository) : IGetBookByIdUseCase {
    override fun execute(getBookByIdQuery: GetBookByIdQuery): BookResponse {
        var book = repository.findById(getBookByIdQuery.id).get()
            ?: throw Exception("Book not found!")

        return book.toBookResponse()
    }
}