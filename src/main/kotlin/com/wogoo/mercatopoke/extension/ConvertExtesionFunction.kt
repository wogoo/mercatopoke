package com.wogoo.mercatopoke.extension

import com.wogoo.mercatopoke.controller.request.PostPokeRequest
import com.wogoo.mercatopoke.controller.request.PostCustomerRequest
import com.wogoo.mercatopoke.controller.request.PutCustomerRequest
import com.wogoo.mercatopoke.controller.request.PutPokeRequest
import com.wogoo.mercatopoke.enums.CustomerStatus
import com.wogoo.mercatopoke.enums.PokeStatus
import com.wogoo.mercatopoke.model.CustomerModel
import com.wogoo.mercatopoke.model.PokeModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email =  this.email, status = CustomerStatus.ATIVO)
}
fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email =  this.email, status = previousValue.status)
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