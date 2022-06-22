package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.BookModel
import org.springframework.data.repository.CrudRepository

interface IBookRepository : CrudRepository<BookModel, Long> {
}