package com.mercadolivro.infrastructure.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name="customer")
data class CustomerModel(

    @Id
    var id: UUID,
    @Column
    var name: String,
    @Column
    var email: String

)