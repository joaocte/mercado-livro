package com.mercadolivro.application.usecase.book.getBook

import com.mercadolivro.application.query.book.GetBookByIdQuery
import com.mercadolivro.application.response.BookResponse

interface IGetBookByIdUseCase {
    fun execute(getBookByIdQuery: GetBookByIdQuery)  : BookResponse
}