package com.wogoo.mercatopoke.controller.response

import com.wogoo.mercatopoke.enums.CustomerStatus
import javax.persistence.*

data class CustomerResponse(

    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus
)
