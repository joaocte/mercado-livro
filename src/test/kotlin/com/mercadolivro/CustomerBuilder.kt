package com.mercadolivro

import com.mercadolivro.infrastructure.model.CustomerModel
import com.mercadolivro.infrastructure.model.CustomerStatusModel
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION
import java.util.*
import kotlin.random.Random

class CustomerBuilder {
   companion object {
       fun BuildCustomer() : Optional<CustomerModel> {
           var customerModel = CustomerModel(
            Random.nextLong(),
            "customer name",
            "${UUID.randomUUID()}@email.com",
            CustomerStatusModel.ACTIVE
            )
           return Optional.of(customerModel)
        }
   }
}