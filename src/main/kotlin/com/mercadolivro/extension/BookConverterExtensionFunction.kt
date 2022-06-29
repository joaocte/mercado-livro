package com.mercadolivro.extension

import com.mercadolivro.application.command.CreateBookCommand
import com.mercadolivro.application.request.CreateBookRequest
import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.application.response.CreateBookCommandResponse
import com.mercadolivro.application.response.CreateBookRequestResponse
import com.mercadolivro.domain.Book
import com.mercadolivro.domain.BookStatus
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.model.CustomerModel

fun BookStatusModel.toDomain() : BookStatus {
    return enumValueOf(this.name)
}

fun BookStatus.toModel() : BookStatusModel{
    return enumValueOf(this.name)
}



fun CreateBookRequest.toCommand() : CreateBookCommand{
    return CreateBookCommand(this.name, this.price, this.customerId)
}

fun CreateBookCommandResponse.toRequestResponse() : CreateBookRequestResponse{
    return CreateBookRequestResponse(this.id)
}

fun CreateBookCommand.toDomain(bookStatus: BookStatus) : Book{
    return Book(name = this.name, price = this.price, status =  bookStatus, customerId = this.customerId, id = null)
}

fun Book.toModel(customerModel : CustomerModel?) : BookModel{
    return BookModel(name = this.name, price =  this.price, status =  this.status!!.toModel(), customerModel =  customerModel, id = null)
}
fun BookModel.toBookResponse() : BookResponse{
    return BookResponse(this.id!!, this.name, this.price, this.status.toString(), this.customerModel?.id!!)
}