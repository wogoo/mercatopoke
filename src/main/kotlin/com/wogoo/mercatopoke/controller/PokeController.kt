package com.wogoo.mercatopoke.controller

import com.wogoo.mercatopoke.controller.request.PostPokeRequest
import com.wogoo.mercatopoke.controller.request.PutPokeRequest
import com.wogoo.mercatopoke.controller.response.PokeResponse
import com.wogoo.mercatopoke.extension.toPokeModel
import com.wogoo.mercatopoke.extension.toResponse
import com.wogoo.mercatopoke.service.CustomerService
import com.wogoo.mercatopoke.service.PokeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("poke")
class PokeController(
    val pokeService: PokeService,
    val customerService: CustomerService
)

    {
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        fun create(@RequestBody @Valid request: PostPokeRequest) {
            val customer = customerService.findById(request.customerId)
            pokeService.create(request.toPokeModel(customer))
        }

        @GetMapping
        fun findAll(@PageableDefault(page = 0, size = 10)pageable: Pageable): Page<PokeResponse> {
            return pokeService.findAll(pageable).map { it.toResponse() }
        }

        @GetMapping("/active")
        fun findActives(@PageableDefault(page = 0, size = 10)pageable: Pageable): Page<PokeResponse> =
             pokeService.findActives(pageable).map { it.toResponse() }

        @GetMapping("/{id}")
        fun findById(@PathVariable id: Int): PokeResponse {
            return pokeService.findById(id).toResponse()
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