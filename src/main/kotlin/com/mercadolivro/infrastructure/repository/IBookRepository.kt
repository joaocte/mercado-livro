package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface IBookRepository : JpaRepository<BookModel, Long> {
    fun existsByNameAndCustomerModel(name:String, customerModel: CustomerModel): Boolean
    fun findByStatus(statusModel: BookStatusModel, pageable: Pageable) : Page<BookModel>
    fun findByCustomerModel(customerModel: CustomerModel): List<BookModel>

}