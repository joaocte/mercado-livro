package com.mercadolivro.application.usecase.book.getBook

import com.mercadolivro.application.query.book.GetBookByIdQuery
import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.extension.toBookResponse
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Service

@Service
class GetbookByIdUseCase (val repository: IBookRepository) : IGetBookByIdUseCase {
    override fun execute(getBookByIdQuery: GetBookByIdQuery): BookResponse {
        var book = repository.findById(getBookByIdQuery.id)

        if(!book.isPresent)
            throw NotFoundException(Errors.MLB1000.message.format(getBookByIdQuery.id), Errors.MLB1000.code)

        return book.get().toBookResponse()
    }
}