package com.wogoo.mercatopoke.controller

import com.wogoo.mercatopoke.controller.request.PostPokeRequest
import com.wogoo.mercatopoke.extension.toPokeModel
import com.wogoo.mercatopoke.service.CustomerService
import com.wogoo.mercatopoke.service.PokeService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("poke")
class PokeController(
    val pokeService: PokeService,
    val customerService: CustomerService
)

    {
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        fun create(@RequestBody request: PostPokeRequest) {
            val customer = customerService.getById(request.customerId)
            pokeService.create(request.toPokeModel(customer))
        }
    }