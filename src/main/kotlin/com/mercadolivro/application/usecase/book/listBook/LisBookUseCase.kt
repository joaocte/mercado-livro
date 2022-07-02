package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.extension.toBookResponse
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class LisBookUseCase(val bookRepository: IBookRepository)  : IListBookUseCase {
    override fun execute(pageble: Pageable): Page<BookResponse> {
        val books =  bookRepository.findAll(pageble)

        if(books.isEmpty)
            throw NotFoundException(Errors.MLB1001.message, Errors.MLB1001.code)

        return books.map { it.toBookResponse() }
    }
}