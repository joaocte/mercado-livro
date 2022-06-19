package com.mercadolivro.extension

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.GetAllCustomersFilter
import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.domain.Customer
import com.mercadolivro.infrastructure.model.CustomerModel
import java.util.*

fun CreateCustomerRequest.toCreateCustomerCommand(): CreateCustomerCommand{
    return CreateCustomerCommand(this.name, this.email)
}


fun UpdateCustomerRequest.toUpdateCustomerCommand(id: Long): UpdateCustomerCommand{
    return UpdateCustomerCommand(id,this.name, this.email)
}

fun Long.toGetCustomerByIdQuery() : GetCustomerByIdQuery{
    return  GetCustomerByIdQuery(this)
}

fun Long.toDeleteCustomerByIdCommand(): DeleteCustomerByIdCommand{
    return DeleteCustomerByIdCommand(this)
}

fun CreateCustomerCommand.toCustomerModelInfra() : CustomerModel {
    return CustomerModel(null, this.name, this.email)
}
fun UpdateCustomerCommand.toCustomerModelInfra(): CustomerModel {
    return CustomerModel(this.id, this.name, this.email)
}

fun CreateCustomerCommand.toCustomerModelDomain() : Customer {
    return  Customer (null, this.name, this.email)
}
fun UpdateCustomerCommand.toCustomerModelDomain():  Customer  {
    return  Customer (this.id, this.name, this.email)
}
fun  Customer.toModel() : CustomerModel{
    return CustomerModel(this.id, this.name, this.email)
}

fun  CustomerModel.toDomain() : Customer{
    return Customer(this.id, this.name, this.email)
}

fun String?.toGetAllCustomersFilter(): GetAllCustomersFilter {
    this?.let {
        return GetAllCustomersFilter(this)
    }
    return GetAllCustomersFilter(null)
}