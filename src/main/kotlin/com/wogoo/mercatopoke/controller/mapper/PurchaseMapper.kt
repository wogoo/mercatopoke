package com.wogoo.mercatopoke.controller.mapper

import com.wogoo.mercatopoke.controller.request.PostPurchaseRequest
import com.wogoo.mercatopoke.model.PurchaseModel
import com.wogoo.mercatopoke.service.CustomerService
import com.wogoo.mercatopoke.service.PokeService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val pokeService: PokeService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val pokes = pokeService.finAllByIds(request.pokeIds)

        return PurchaseModel(
            customer = customer,
            pokes = pokes.toMutableList(),
            price = pokes.sumOf { it.price }
        )
    }
}