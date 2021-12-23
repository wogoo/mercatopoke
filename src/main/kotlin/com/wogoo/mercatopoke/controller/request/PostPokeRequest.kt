package com.wogoo.mercatopoke.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostPokeRequest (
    var name: String,

    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int

        )