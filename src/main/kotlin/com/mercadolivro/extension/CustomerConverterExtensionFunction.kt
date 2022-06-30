package com.mercadolivro.extension

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.customer.GetAllCustomersFilter
import com.mercadolivro.application.query.customer.GetCustomerByIdQuery
import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import com.mercadolivro.domain.BookStatus
import com.mercadolivro.domain.Customer
import com.mercadolivro.domain.CustomerStatus
import com.mercadolivro.infrastructure.model.BookStatusModel
import com.mercadolivro.infrastructure.model.CustomerModel
import com.mercadolivro.infrastructure.model.CustomerStatusModel

fun CreateCustomerRequest.toCreateCustomerCommand(): CreateCustomerCommand{
    return CreateCustomerCommand(this.name, this.email)
}


fun UpdateCustomerRequest.toUpdateCustomerCommand(id: Long): UpdateCustomerCommand{
    return UpdateCustomerCommand(id,this.name, this.email, this.status)
}

fun Long.toGetCustomerByIdQuery() : GetCustomerByIdQuery {
    return  GetCustomerByIdQuery(this)
}

fun Long.toDeleteCustomerByIdCommand(): DeleteCustomerByIdCommand{
    return DeleteCustomerByIdCommand(this)
}

fun CreateCustomerCommand.toCustomerModelInfra() : CustomerModel {
    return CustomerModel(null, this.name, this.email, CustomerStatusModel.ACTIVE)
}
fun UpdateCustomerCommand.toCustomerModelInfra(): CustomerModel {
    return CustomerModel(this.id, this.name, this.email, this.status.toModel())
}

fun CreateCustomerCommand.toCustomerModelDomain() : Customer {
    return  Customer (null, this.name, this.email, CustomerStatus.ACTIVE)
}
fun UpdateCustomerCommand.toCustomerModelDomain():  Customer  {
    return  Customer (this.id, this.name, this.email, this.status)
}
fun  Customer.toModel() : CustomerModel{
    return CustomerModel(this.id, this.name, this.email, this.status.toModel())
}

fun  CustomerModel.toDomain() : Customer{
    return Customer(this.id, this.name, this.email, this.status.toDomain())
}

fun String?.toGetAllCustomersFilter(): GetAllCustomersFilter {
    this?.let {
        return GetAllCustomersFilter(this)
    }
    return GetAllCustomersFilter(null)
}

fun CustomerStatusModel.toDomain() : CustomerStatus {
    return enumValueOf(this.name)
}

fun CustomerStatus.toModel() : CustomerStatusModel {
    return enumValueOf(this.name)
}
