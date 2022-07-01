package com.mercadolivro.application.response

import com.mercadolivro.domain.CustomerStatus
import java.util.*

data class CustomerResponse (

    var id: Long?,
    var name: String,
    var email: String,
    var status : CustomerStatus

)