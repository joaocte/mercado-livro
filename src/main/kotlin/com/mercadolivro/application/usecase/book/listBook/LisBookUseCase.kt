package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.extension.toBookResponse
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LisBookUseCase(val bookRepository: IBookRepository)  : IListBookUseCase {
    override fun execute(pageble: Pageable): Page<BookResponse> {
        return bookRepository.findAll(pageble).map {it.toBookResponse() };
    }
}