package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ICustomerRepository : JpaRepository<CustomerModel, Long> {
    fun findByNameContaining(name:String, pageable: Pageable): Page<CustomerModel>
    fun existsByEmail(email:String) : Boolean
}