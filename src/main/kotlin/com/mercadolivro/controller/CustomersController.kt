package com.mercadolivro.controller

import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.application.response.CustomerResponse
import com.mercadolivro.application.usecase.customer.createCustomer.ICreateCustomerUseCase
import com.mercadolivro.application.usecase.customer.deleteCustomer.IDeleteCustomerUseCase
import com.mercadolivro.application.usecase.customer.getcustomer.IGetAllCustomersUseCase
import com.mercadolivro.application.usecase.customer.getcustomer.IGetCustomerByIdUseCase
import com.mercadolivro.application.usecase.customer.updateCustomer.IUpdateCustomerUseCase
import com.mercadolivro.extension.*
import com.mercadolivro.openApi.ICustomersController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("customers")
class CustomersController (
    private val createCustomerUseCase: ICreateCustomerUseCase,
    private val getCustomerById: IGetCustomerByIdUseCase,
    private val getAllCustomersUseCase: IGetAllCustomersUseCase,
    private val updateCustomerUsecase: IUpdateCustomerUseCase,
    private val deleteCustomerUseCase: IDeleteCustomerUseCase
                           ) : ICustomersController {


    @GetMapping
    override fun getAll(@RequestParam name: String?, @PageableDefault(page = 0, size = 10) pageble: Pageable): Page<CustomerResponse> {
            return getAllCustomersUseCase.execute(name?.toGetAllCustomersFilter(), pageble)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun createCustomer(@RequestBody @Valid createCustomerRequest: CreateCustomerRequest) {
        createCustomerUseCase.execute(createCustomerRequest.toCreateCustomerCommand())
    }

    @GetMapping("/{id}")
    override fun getById(@PathVariable id: Long): CustomerResponse {
        return  getCustomerById.execute(id.toGetCustomerByIdQuery())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun updateCustomer(@PathVariable id: Long, @RequestBody @Valid updateCustomerRequest: UpdateCustomerRequest){
        updateCustomerUsecase.execute(updateCustomerRequest.toUpdateCustomerCommand(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun deleteCustomer(@PathVariable id: Long){
        deleteCustomerUseCase.execute(id.toDeleteCustomerByIdCommand())
    }
}