package com.mercadolivro.infrastructure.model

import java.math.BigDecimal
import javax.persistence.*

@Entity(name="book")
data class BookModel(

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id: Long?,
    @Column
    var name: String,
    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatusModel? = null,

    @ManyToOne
    @JoinColumn(name="customer_id")
    var customerModel: CustomerModel? = null



)