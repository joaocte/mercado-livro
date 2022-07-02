package com.mercadolivro.infrastructure.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

data class PurchaseModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,

    @ManyToMany
    @JoinTable(
    name = "purchase_book",
    joinColumns = [JoinColumn(name = "purchase_id")],
    inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    val books: List<BookModel>,

    @Column
    val nfe: String,

    @Column
    val price: BigDecimal,

    @Column(name = "created_at")
    @CreatedDate
    val createdAt: LocalDateTime,

    @Column(name = "updated_at")
    @LastModifiedDate
    val updatedAt: LocalDateTime
    )