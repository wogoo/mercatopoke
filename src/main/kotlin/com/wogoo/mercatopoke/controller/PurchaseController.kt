package com.wogoo.mercatopoke.controller

import com.wogoo.mercatopoke.controller.mapper.PurchaseMapper
import com.wogoo.mercatopoke.controller.request.PostPurchaseRequest
import com.wogoo.mercatopoke.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("purchases")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request))
    }
}