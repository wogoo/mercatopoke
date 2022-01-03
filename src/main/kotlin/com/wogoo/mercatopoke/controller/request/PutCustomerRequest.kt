package com.wogoo.mercatopoke.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest (

    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "Email deve ser válido ")
    var email: String,

//    @field:NotEmpty(message = "A senha deve ser informada")
//    var password: String
        )