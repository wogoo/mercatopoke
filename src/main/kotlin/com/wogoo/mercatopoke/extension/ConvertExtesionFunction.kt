package com.wogoo.mercatopoke.extension

import com.wogoo.mercatopoke.controller.request.PostPokeRequest
import com.wogoo.mercatopoke.controller.request.PostCustomerRequest
import com.wogoo.mercatopoke.controller.request.PutCustomerRequest
import com.wogoo.mercatopoke.controller.request.PutPokeRequest
import com.wogoo.mercatopoke.controller.response.CustomerResponse
import com.wogoo.mercatopoke.controller.response.PokeResponse
import com.wogoo.mercatopoke.enums.CustomerStatus
import com.wogoo.mercatopoke.enums.PokeStatus
import com.wogoo.mercatopoke.model.CustomerModel
import com.wogoo.mercatopoke.model.PokeModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email =  this.email, status = CustomerStatus.ATIVO, password = this.password)
}
fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email =  this.email, status = previousValue.status, password = previousValue.password)
}
fun PostPokeRequest.toPokeModel(customer: CustomerModel): PokeModel {
    return PokeModel(
        name = this.name,
        price = this.price,
        status = PokeStatus.ATIVO,
        customer = customer
    )
}
fun PutPokeRequest.toPokeModel(previousValue: PokeModel): PokeModel {
    return PokeModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun PokeModel.toResponse(): PokeResponse {
    return PokeResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}
