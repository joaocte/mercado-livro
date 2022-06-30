package com.mercadolivro.controller

import com.mercadolivro.application.request.CreateBookRequest
import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.application.response.BookResponse
import com.mercadolivro.application.response.CreateBookCommandResponse
import com.mercadolivro.application.usecase.book.createBook.ICreateBookUseCase
import com.mercadolivro.application.usecase.book.getBook.IGetBookByIdUseCase
import com.mercadolivro.application.usecase.book.listBook.IListActivateBookUseCase
import com.mercadolivro.application.usecase.book.listBook.IListBookUseCase
import com.mercadolivro.application.usecase.book.listBook.ListActivateBookUseCase
import com.mercadolivro.application.usecase.customer.createCustomer.ICreateCustomerUseCase
import com.mercadolivro.application.usecase.customer.deleteCustomer.IDeleteCustomerUseCase
import com.mercadolivro.application.usecase.customer.getcustomer.IGetAllCustomersUseCase
import com.mercadolivro.application.usecase.customer.getcustomer.IGetCustomerByIdUseCase
import com.mercadolivro.application.usecase.customer.updateCustomer.IUpdateCustomerUseCase
import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController (
    private val createBookUseCase: ICreateBookUseCase,
    private val getBookByIdUseCase: IGetBookByIdUseCase,
    private val listBookUseCase: IListBookUseCase,
    private val listActivateBookUseCase: IListActivateBookUseCase,
                           ) {
    @GetMapping
    fun getAll(): List<BookResponse> {
            return listBookUseCase.execute()
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody createBookRequest: CreateBookRequest) {
        createBookUseCase.execute(createBookRequest.toCommand())
    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): BookResponse {
        return  getBookByIdUseCase.execute(id.toGetBookByIdQuery())
    }
    @GetMapping("/active")
    fun getById(): List<BookResponse> {
        return  listActivateBookUseCase.execute()
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun updateCustomer(@PathVariable id: Long, @RequestBody updateCustomerRequest: UpdateCustomerRequest){
//        updateCustomerUsecase.execute(updateCustomerRequest.toUpdateCustomerCommand(id))
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteCustomer(@PathVariable id: Long){
//        deleteCustomerUseCase.execute(id.toDeleteCustomerByIdCommand())
//    }
}