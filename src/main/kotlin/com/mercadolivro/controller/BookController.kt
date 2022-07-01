package com.mercadolivro.controller

import com.mercadolivro.application.request.CreateBookRequest
import com.mercadolivro.application.request.UpdateBookRequest
import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.application.usecase.book.createBook.ICreateBookUseCase
import com.mercadolivro.application.usecase.book.deleteBook.IDeleteBookByIdUseCase
import com.mercadolivro.application.usecase.book.getBook.IGetBookByIdUseCase
import com.mercadolivro.application.usecase.book.listBook.IListActivateBookUseCase
import com.mercadolivro.application.usecase.book.listBook.IListBookUseCase
import com.mercadolivro.application.usecase.book.updateBook.IUpdateBookUseCase
import com.mercadolivro.extension.toCommand
import com.mercadolivro.extension.toDeleteBookByIdCommand
import com.mercadolivro.extension.toGetBookByIdQuery
import com.mercadolivro.extension.toUpdateBookCommand
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("books")
class BookController (
    private val createBookUseCase: ICreateBookUseCase,
    private val getBookByIdUseCase: IGetBookByIdUseCase,
    private val listBookUseCase: IListBookUseCase,
    private val listActivateBookUseCase: IListActivateBookUseCase,
    private val deleteBookUseCase : IDeleteBookByIdUseCase,
    private val updateBookUseCase: IUpdateBookUseCase
                           ) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid createBookRequest: CreateBookRequest) {
        createBookUseCase.execute(createBookRequest.toCommand())
    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): BookResponse {
        return  getBookByIdUseCase.execute(id.toGetBookByIdQuery())
    }
    @GetMapping("/active")
    fun getActive(@PageableDefault(page = 0, size = 10) pageble: Pageable): Page<BookResponse> {
        return  listActivateBookUseCase.execute(pageble)
    }
    @GetMapping
    fun getAll(@PageableDefault(page = 0, size = 10) pageble: Pageable): Page<BookResponse> {
        return listBookUseCase.execute(pageble)
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Long, @RequestBody @Valid updateBookRequest: UpdateBookRequest){
        updateBookUseCase.execute(updateBookRequest.toUpdateBookCommand(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Long){
        deleteBookUseCase.execute(id.toDeleteBookByIdCommand())
    }
}

