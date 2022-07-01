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

    @ManyToOne
    @JoinColumn(name="customer_id")
    var customerModel: CustomerModel? = null
)
{

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatusModel? = null
    set(value) {
        if(field == BookStatusModel.CANCELED || field == BookStatusModel.DELETED)
            throw Exception("Não é possivel alterar status de um livro, pois este encontra-se $field")
        field = value
    }

    constructor(id: Long?,
                name: String,
                price: BigDecimal,
                status: BookStatusModel?,
                customerModel: CustomerModel?)
            : this(id, name,price,customerModel){
        this.status = status
    }
}