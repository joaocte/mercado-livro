package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface ICustomerRepository : CrudRepository<CustomerModel, Long> {
    fun findByNameContaining(name:String): List<CustomerModel>
    fun existsByEmail(email:String) : Boolean
}