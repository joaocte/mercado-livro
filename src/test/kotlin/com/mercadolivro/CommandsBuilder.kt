package com.mercadolivro

import com.mercadolivro.application.command.CreateBookCommand
import com.mercadolivro.domain.BookStatus
import java.math.BigDecimal

class CommandsBuilder {
    companion object {
        fun createBookCoomandBuilder(customerId : Long) : CreateBookCommand {
            return CreateBookCommand("bookName", BigDecimal(16),customerId,BookStatus.ACTIVE)
        }
    }
}