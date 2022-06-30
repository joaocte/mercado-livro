package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.BookResponse

interface IListBookUseCase{
     fun execute()  : List<BookResponse>
 }