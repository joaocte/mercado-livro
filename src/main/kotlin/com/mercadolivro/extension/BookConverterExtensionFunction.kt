package com.mercadolivro.extension

import com.mercadolivro.application.command.CreateBookCommand
import com.mercadolivro.application.command.DeleteBookByIdCommand
import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateBookCommand
import com.mercadolivro.application.query.book.GetBookByIdQuery
import com.mercadolivro.application.request.CreateBookRequest
import com.mercadolivro.application.request.UpdateBookRequest
import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.application.response.CreateBookCommandResponse
import com.mercadolivro.application.response.CreateBookRequestResponse
import com.mercadolivro.domain.Book
import com.mercadolivro.domain.BookStatus
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.model.CustomerModel
import org.hibernate.loader.plan.exec.process.spi.ReturnReader
import org.springframework.data.domain.Page

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

fun Long.toGetBookByIdQuery(): GetBookByIdQuery {
    return GetBookByIdQuery(this)
}
fun Long.toDeleteBookByIdCommand() : DeleteBookByIdCommand {
    return DeleteBookByIdCommand(this)
}
fun UpdateBookCommand.toModel(bookModel: BookModel) : BookModel{
    return BookModel(this.id, this.name, this.price, bookModel.status, bookModel.customerModel)
}

fun UpdateBookRequest.toUpdateBookCommand(id: Long): UpdateBookCommand {
    return UpdateBookCommand(id, this.name, this.price)
}


fun BookModel.toDomain()  : Book{
    return Book(this.id, this.name, this.price, this.status?.toDomain(), this.customerModel?.id   )
}