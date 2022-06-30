package com.mercadolivro.infrastructure.model

import java.util.UUID
import javax.persistence.*

@Entity(name="customer")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id: Long?,
    @Column
    var name: String,
    @Column
    var email: String,
    @Column
    var status : CustomerStatusModel

)