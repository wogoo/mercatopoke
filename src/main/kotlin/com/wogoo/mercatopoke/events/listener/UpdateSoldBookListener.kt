package com.wogoo.mercatopoke.events.listener

import com.wogoo.mercatopoke.events.PurchaseEvent
import com.wogoo.mercatopoke.service.PokeService
import com.wogoo.mercatopoke.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldBookListener(
    private val pokeService: PokeService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {

        pokeService.purchase(purchaseEvent.purchaseModel.pokes)
    }

}