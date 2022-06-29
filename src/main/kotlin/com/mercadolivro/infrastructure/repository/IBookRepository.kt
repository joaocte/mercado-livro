package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface IBookRepository : CrudRepository<BookModel, Long> {
    fun existsByNameAndCustomerId(name:String, customerId : Long): Boolean
}