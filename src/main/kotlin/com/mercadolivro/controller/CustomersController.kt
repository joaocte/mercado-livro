package com.mercadolivro.controller

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.extension.toCreateCustomerCommand
import com.mercadolivro.extension.toDeleteCustomerByIdCommand
import com.mercadolivro.extension.toGetCustomerByIdQuery
import com.mercadolivro.extension.toUpdateCustomerCommand
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.services.ICustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("customers")
class CustomersController (val customerService: ICustomerService) {


    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody createCustomerRequest: CreateCustomerRequest) {
        customerService.createCustomer(createCustomerRequest.toCreateCustomerCommand())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): CustomerModel {
        return  customerService.getById(id.toGetCustomerByIdQuery())
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