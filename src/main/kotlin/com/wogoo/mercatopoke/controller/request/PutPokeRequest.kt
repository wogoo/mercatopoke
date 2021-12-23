package com.wogoo.mercatopoke.controller.request

import java.math.BigDecimal

data class PutPokeRequest(
    var name: String?,
    var price: BigDecimal?
)
