package com.mercadolivro.application.request

import com.mercadolivro.domain.CustomerStatus

data class UpdateCustomerRequest(var name: String, var email: String)