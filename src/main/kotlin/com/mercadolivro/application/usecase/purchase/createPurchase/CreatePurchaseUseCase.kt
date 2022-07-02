package com.mercadolivro.application.usecase.purchase.createPurchase

import com.mercadolivro.application.command.CreatePurchaseCommand
import com.mercadolivro.domain.Purchase
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.exception.customException.PreconditionFailedException
import com.mercadolivro.extension.listOfField
import com.mercadolivro.extension.toDomain
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import com.mercadolivro.infrastructure.repository.IPurchaseRepository
import com.mercadolivro.message.events.PurchaseMade
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class CreatePurchaseUseCase (private val repository: IPurchaseRepository,
                             private val customerRepository : ICustomerRepository,
                             private val bookRepository: IBookRepository,
                             private val applicationEventPublisher: ApplicationEventPublisher) : ICreatePurchaseUseCase {
    override fun execute(createPurchaseCommand: CreatePurchaseCommand)
    {
        val customer = customerRepository.findById(createPurchaseCommand.customerId)

        if(!customer.isPresent)
            throw NotFoundException(Errors.MLC2000.message.format(createPurchaseCommand.customerId), Errors.MLC2000.code)

        val books = bookRepository.findAllById(createPurchaseCommand.bookIds)

        if(books.isEmpty())
            throw NotFoundException(Errors.MLB1000.message.format(createPurchaseCommand.bookIds.joinToString { it.toString() }), Errors.MLB1000.code)

        if(books.size < createPurchaseCommand.bookIds.size) {
            val foundBooks = books.listOfField(BookModel::id).toSet()
            val distinctBooks = createPurchaseCommand.bookIds.minus(foundBooks)
            throw PreconditionFailedException(Errors.MLB1004.message.format(distinctBooks.joinToString { it.toString() }), Errors.MLB1004.code)
        }

        val purchase = Purchase(
            null,
            customer.get().toDomain(),
            books.map { it.toDomain() },
            null ,
            books.sumOf { it.price }
        )
        val purchaseModel = purchase.toModel()
        repository.save(purchaseModel)

        applicationEventPublisher.publishEvent(PurchaseMade(this, purchaseModel))
    }
}

