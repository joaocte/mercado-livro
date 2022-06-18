package com.mercadolivro.controller

import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.application.usecase.createCustomer.ICreateCustomerUseCase
import com.mercadolivro.application.usecase.getcustomer.IGetCustomerByIdUseCase
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.extension.toCreateCustomerCommand
import com.mercadolivro.extension.toDeleteCustomerByIdCommand
import com.mercadolivro.extension.toGetCustomerByIdQuery
import com.mercadolivro.extension.toUpdateCustomerCommand
import com.mercadolivro.services.ICustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("customers")
class CustomersController (private val customerService: ICustomerService, private val createCustomerUseCase: ICreateCustomerUseCase,
private val getCustomerById: IGetCustomerByIdUseCase
                           ) {


//    @GetMapping
//    fun getAll(@RequestParam name: String?): List<CustomerModel> {
////        return customerService.getAll(name)
//
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody createCustomerRequest: CreateCustomerRequest) {
        createCustomerUseCase.execute(createCustomerRequest.toCreateCustomerCommand())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): CustomerModel {
        return  getCustomerById.execute(id.toGetCustomerByIdQuery())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: UUID, @RequestBody updateCustomerRequest: UpdateCustomerRequest){
        return customerService.updateCustomer(updateCustomerRequest.toUpdateCustomerCommand(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: UUID){
       customerService.deleteCustomer(id.toDeleteCustomerByIdCommand())
    }
}