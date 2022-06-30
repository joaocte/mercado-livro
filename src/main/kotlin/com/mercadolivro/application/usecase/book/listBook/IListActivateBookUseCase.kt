package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.BookResponse

interface IListActivateBookUseCase {
    fun execute()  : List<BookResponse>
}