package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.CustomerModel
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CustomerRepository : CrudRepository<CustomerModel, UUID> {
}