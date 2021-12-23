package com.wogoo.mercatopoke.controller.request

import com.wogoo.mercatopoke.model.CustomerModel

data class PostCustomerRequest (
    var name: String,
    var email: String
        ) {

}