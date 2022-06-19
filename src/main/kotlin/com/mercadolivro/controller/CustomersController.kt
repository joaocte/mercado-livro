package com.mercadolivro.controller

import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.application.usecase.createCustomer.ICreateCustomerUseCase
import com.mercadolivro.application.usecase.getcustomer.GetAllCustomersUseCase
import com.mercadolivro.application.usecase.getcustomer.GetCustomerByIdUseCase
import com.mercadolivro.application.usecase.updateCustomer.UpdateCustomerUseCase
import com.mercadolivro.domain.Customer
import com.mercadolivro.extension.*
import com.mercadolivro.services.ICustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("customers")
class CustomersController (
    private val customerService: ICustomerService,
    private val createCustomerUseCase: ICreateCustomerUseCase,
    private val getCustomerById: GetCustomerByIdUseCase,
    private val getAllCustomersUseCase: GetAllCustomersUseCase,
    private val updateCustomerUsecase: UpdateCustomerUseCase
                           ) {


    @GetMapping
    fun getAll(@RequestParam name: String?): List<Customer> {
            return getAllCustomersUseCase.execute(name?.toGetAllCustomersFilter())

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody createCustomerRequest: CreateCustomerRequest) {
        createCustomerUseCase.execute(createCustomerRequest.toCreateCustomerCommand())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Customer {
        return  getCustomerById.execute(id.toGetCustomerByIdQuery())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Long, @RequestBody updateCustomerRequest: UpdateCustomerRequest){
        updateCustomerUsecase.execute(updateCustomerRequest.toUpdateCustomerCommand(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long){
       customerService.deleteCustomer(id.toDeleteCustomerByIdCommand())
    }
}