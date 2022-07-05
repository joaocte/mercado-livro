package com.mercadolivro

import com.mercadolivro.application.command.CreateBookCommand
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.model.CustomerModel
import java.math.BigDecimal
import java.util.*
import kotlin.random.Random

class BookBuilder {
   companion object {
       fun BuildBook(ceateBookCommand: CreateBookCommand ,customerModel : CustomerModel) : Optional<BookModel> {
           var bookModel = BookModel(
            Random.nextLong(),
               ceateBookCommand.name,
           ceateBookCommand.price,
               ceateBookCommand.status.toModel(),
               customerModel
            )
           return Optional.of(bookModel)
        }
   }
}