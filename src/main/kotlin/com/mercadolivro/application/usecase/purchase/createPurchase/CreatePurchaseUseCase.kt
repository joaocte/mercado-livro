package com.mercadolivro.application.usecase.purchase.createPurchase

import com.mercadolivro.application.command.CreatePurchaseCommand
import com.mercadolivro.domain.Book
import com.mercadolivro.domain.Purchase
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.exception.customException.PreconditionFailedException
import com.mercadolivro.extension.listOfField
import com.mercadolivro.extension.toBookResponse
import com.mercadolivro.extension.toDomain
import com.mercadolivro.extension.toModel
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import com.mercadolivro.infrastructure.repository.IPurchaseRepository
import org.springframework.stereotype.Service

@Service
class CreatePurchaseUseCase (private val repository: IPurchaseRepository,
                             private val customerRepository : ICustomerRepository,
                             private val bookRepository: IBookRepository) : ICreatePurchaseUseCase {
    override fun execute(createPurchaseCommand: CreatePurchaseCommand)
    {
        var customer = customerRepository.findById(createPurchaseCommand.customerId)

        if(!customer.isPresent)
            throw NotFoundException(Errors.MLC2000.message.format(createPurchaseCommand.customerId), Errors.MLC2000.code)

        var books = bookRepository.findAllById(createPurchaseCommand.bookIds)

        if(books.isEmpty())
            throw NotFoundException(Errors.MLB1000.message.format(createPurchaseCommand.bookIds.joinToString { it.toString() }), Errors.MLB1000.code)

        if(books.size < createPurchaseCommand.bookIds.size) {
            var foundBooks = books.listOfField(BookModel::id).toSet()
            var distinctBooks = createPurchaseCommand.bookIds.minus(foundBooks)
            throw PreconditionFailedException(Errors.MLB1004.message.format(distinctBooks.joinToString { it.toString() }), Errors.MLB1004.code)
        }

        var purchase = Purchase(
            null,
            customer.get().toDomain(),
            books.map { it.toDomain() },
            null ,
            books.sumOf { it.price }
        )
        var purchaseModel = purchase.toModel()
        repository.save(purchaseModel)
    }
}

