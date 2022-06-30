package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.model.CustomerModel
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface IBookRepository : CrudRepository<BookModel, Long> {
    fun existsByNameAndCustomerModel(name:String, customerModel: CustomerModel): Boolean
    fun findByStatus(statusModel: BookStatusModel) : List<Optional<BookModel>>
}