package com.wogoo.mercatopoke.controller

import com.wogoo.mercatopoke.controller.request.PostPokeRequest
import com.wogoo.mercatopoke.controller.request.PutPokeRequest
import com.wogoo.mercatopoke.extension.toPokeModel
import com.wogoo.mercatopoke.model.PokeModel
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
            val customer = customerService.findById(request.customerId)
            pokeService.create(request.toPokeModel(customer))
        }

        @GetMapping
        fun findAll(): List<PokeModel> {
            return pokeService.findAll()
        }

        @GetMapping("/active")
        fun findActives(): List<PokeModel> =
             pokeService.findActives()

        @GetMapping("/{id}")
        fun findById(@PathVariable id: Int): PokeModel {
            return pokeService.findById(id)
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        fun delete(@PathVariable id: Int) {
            pokeService.delete(id)
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        fun update(@PathVariable id: Int, @RequestBody poke: PutPokeRequest) {
            val pokeSaved = pokeService.findById(id)
            pokeService.update(poke.toPokeModel(pokeSaved))
        }

    }