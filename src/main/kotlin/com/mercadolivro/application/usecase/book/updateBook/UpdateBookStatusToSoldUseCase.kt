package com.mercadolivro.application.usecase.book.updateBook

import com.mercadolivro.application.command.UpdateBookCommand
import com.mercadolivro.domain.BookStatus
import com.mercadolivro.extension.toDeleteBookByIdCommand
import com.mercadolivro.extension.toDomain
import com.mercadolivro.extension.toUpdateBookCommand
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.message.events.PurchaseMade
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class UpdateBookStatusToSoldUseCase(val repository: IBookRepository) : IUpdateBookStatusToSoldUseCase {
    @Async
    @EventListener
    override fun execute(purchaseMade: PurchaseMade) {
        var books = purchaseMade.purchaseModel.books

        books.map { it.status = BookStatusModel.SOLD }

        repository.saveAll(books)

    }
}


