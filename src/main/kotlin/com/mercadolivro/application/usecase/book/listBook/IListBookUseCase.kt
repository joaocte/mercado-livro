package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.BookResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IListBookUseCase{
     fun execute(pageble: Pageable): Page<BookResponse>
 }