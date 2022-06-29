package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.extension.toBookResponse
import com.mercadolivro.infrastructure.repository.IBookRepository
import org.springframework.stereotype.Service

@Service
class LisBookUseCase(val bookRepository: IBookRepository)  : IListBookUseCase {
    override fun execute(): List<BookResponse> {
        var booksModel = bookRepository.findAll();

      return  booksModel.map { it.toBookResponse() }
    }
}