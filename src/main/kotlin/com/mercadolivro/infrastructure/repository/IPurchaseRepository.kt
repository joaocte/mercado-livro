package com.mercadolivro.infrastructure.repository

import com.mercadolivro.infrastructure.model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface IPurchaseRepository : CrudRepository<PurchaseModel, Long> {
}