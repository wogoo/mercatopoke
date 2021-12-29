package com.wogoo.mercatopoke.events

import com.wogoo.mercatopoke.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
        source: Any,
        val purchaseModel: PurchaseModel
        ): ApplicationEvent(source)