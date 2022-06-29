package com.mercadolivro.application.usecase.book.listBook

import com.mercadolivro.application.response.ListBookResponse

interface IListBookUseCase{
     fun execute()  : List<ListBookResponse>
 }