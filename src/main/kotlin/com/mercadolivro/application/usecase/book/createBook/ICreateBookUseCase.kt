package com.mercadolivro.application.usecase.book.createBook

import com.mercadolivro.application.command.CreateBookCommand
import com.mercadolivro.application.response.CreateBookCommandResponse

interface ICreateBookUseCase {
    fun execute(createBookCommand: CreateBookCommand)  : CreateBookCommandResponse
}