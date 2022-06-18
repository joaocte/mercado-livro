package com.mercadolivro.model

import java.util.EnumMap
import java.util.UUID

data class CustomerModel (

    var id: UUID,
    var name: String,
    var email: String

)