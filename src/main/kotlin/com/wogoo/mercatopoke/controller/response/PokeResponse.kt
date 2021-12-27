package com.wogoo.mercatopoke.controller.response

import com.wogoo.mercatopoke.enums.CustomerStatus
import com.wogoo.mercatopoke.enums.PokeStatus
import com.wogoo.mercatopoke.model.CustomerModel
import java.math.BigDecimal

data class PokeResponse (
    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: PokeStatus? = null
        )
