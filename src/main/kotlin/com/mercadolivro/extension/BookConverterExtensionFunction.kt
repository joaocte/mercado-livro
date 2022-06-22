package com.mercadolivro.extension

import com.mercadolivro.domain.Book
import com.mercadolivro.domain.BookStatus
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel

fun BookStatusModel.toDomain() : BookStatus{
    return enumValueOf(this.name)
}

fun BookStatus.toModel() : BookStatusModel{
    return enumValueOf(this.name)
}

fun BookModel.toDmain(): Book{
    return Book(this.id, this.name, this.price, this.status?.toDomain(), this.customerModel?.toDomain())
}


fun Book.toDmain(): BookModel{
    return BookModel(this.id, this.name, this.price, this.status?.toModel(), this.customerModel?.toModel())
}