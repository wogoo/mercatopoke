package com.wogoo.mercatopoke.extension

import com.wogoo.mercatopoke.controller.request.PostCustomerRequest
import com.wogoo.mercatopoke.controller.request.PutCustomerRequest
import com.wogoo.mercatopoke.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email =  this.email)
}
fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel {
    return CustomerModel(id = id, name = this.name, email =  this.email)
}