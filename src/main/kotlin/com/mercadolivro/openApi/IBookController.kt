package com.mercadolivro.openApi

import com.mercadolivro.application.request.CreateBookRequest
import com.mercadolivro.application.request.UpdateBookRequest
import com.mercadolivro.application.response.BookResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Tag(name = "Book", description = "this API provide methods for operations with Books")
interface IBookController {
    @Operation(summary = "Create new book")
    fun createCustomer(createBookRequest: CreateBookRequest)

    @Operation(summary = "Find a book by id")
    fun getById(id: Long): BookResponse

    @Operation(summary = "Find all books in active status")
    fun getActive(pageble: Pageable): Page<BookResponse>

    @Operation(summary = "return all books")
    fun getAll( pageble: Pageable): Page<BookResponse>

    @Operation(summary = "Update book data by id")
    fun updateCustomer(id: Long, updateBookRequest: UpdateBookRequest)

    @Operation(summary = "Delete a book by id")
    fun deleteBook(id: Long)
}

