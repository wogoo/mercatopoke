package com.wogoo.mercatopoke.service

import com.wogoo.mercatopoke.events.PurchaseEvent
import com.wogoo.mercatopoke.model.PurchaseModel
import com.wogoo.mercatopoke.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
                private val purchaseRepository: PurchaseRepository,
                private val applicationEventPublisher: ApplicationEventPublisher
) {


    fun create(purchaseModel: PurchaseModel){
        purchaseRepository.save(purchaseModel)

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

}
