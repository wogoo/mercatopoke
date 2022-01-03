package com.wogoo.mercatopoke.helper

import com.wogoo.mercatopoke.enums.CustomerStatus
import com.wogoo.mercatopoke.enums.Role
import com.wogoo.mercatopoke.model.CustomerModel
import com.wogoo.mercatopoke.model.PokeModel
import com.wogoo.mercatopoke.model.PurchaseModel
import java.math.BigDecimal
import java.util.*

fun buildCustomer(
    id: Int? = null,
    name: String = "customer name",
    email: String="${UUID.randomUUID()}@poke.com",
    password: String = "password"
) = CustomerModel(
    id = id,
    name = name,
    email = email,
    status = CustomerStatus.ATIVO,
    password = password,
    roles = setOf(Role.CUSTOMER)
)
fun buildPurchase(
    id: Int? = null,
    customer: CustomerModel = buildCustomer(),
    pokes: MutableList<PokeModel> = mutableListOf(),
    nfe: String? = UUID.randomUUID().toString(),
    price: BigDecimal = BigDecimal.TEN
) = PurchaseModel (
    id = id,
    customer = customer,
    pokes = pokes,
    nfe = nfe,
    price = price
)

