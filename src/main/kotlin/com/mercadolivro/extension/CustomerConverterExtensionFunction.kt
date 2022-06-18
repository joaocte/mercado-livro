package com.mercadolivro.extension

import com.mercadolivro.application.command.CreateCustomerCommand
import com.mercadolivro.application.command.DeleteCustomerByIdCommand
import com.mercadolivro.application.command.UpdateCustomerCommand
import com.mercadolivro.application.query.GetCustomerByIdQuery
import com.mercadolivro.application.request.CreateCustomerRequest
import com.mercadolivro.application.request.UpdateCustomerRequest
import java.util.*

fun CreateCustomerRequest.toCreateCustomerCommand(): CreateCustomerCommand{
    return CreateCustomerCommand(UUID.randomUUID(), this.name, this.email)
}


fun UpdateCustomerRequest.toUpdateCustomerCommand(id: UUID): UpdateCustomerCommand{
    return UpdateCustomerCommand(id,this.name, this.email)
}

fun UUID.toGetCustomerByIdQuery() : GetCustomerByIdQuery{
    return  GetCustomerByIdQuery(this)
}

fun UUID.toDeleteCustomerByIdCommand(): DeleteCustomerByIdCommand{
    return DeleteCustomerByIdCommand(this)
}

fun CreateCustomerCommand.toCustomerModelInfra() : com.mercadolivro.infrastructure.model.CustomerModel {
    return com.mercadolivro.infrastructure.model.CustomerModel(this.id, this.name, this.email)
}
fun UpdateCustomerCommand.toCustomerModelInfra(): com.mercadolivro.infrastructure.model.CustomerModel {
    return com.mercadolivro.infrastructure.model.CustomerModel(this.id, this.name, this.email)
}

fun CreateCustomerCommand.toCustomerModelDomain() : com.mercadolivro.domain.CustomerModel {
    return  com.mercadolivro.domain.CustomerModel (this.id, this.name, this.email)
}
fun UpdateCustomerCommand.toCustomerModelDomain():  com.mercadolivro.domain.CustomerModel  {
    return  com.mercadolivro.domain.CustomerModel (this.id, this.name, this.email)
}
fun  com.mercadolivro.domain.CustomerModel.toModel() : com.mercadolivro.infrastructure.model.CustomerModel{
    return com.mercadolivro.infrastructure.model.CustomerModel(this.id, this.name, this.email)
}

fun  com.mercadolivro.infrastructure.model.CustomerModel.toDomain() : com.mercadolivro.domain.CustomerModel{
    return com.mercadolivro.domain.CustomerModel(this.id, this.name, this.email)
}