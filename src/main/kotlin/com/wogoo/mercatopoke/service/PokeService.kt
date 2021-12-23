package com.wogoo.mercatopoke.service

import com.wogoo.mercatopoke.controller.request.PostPokeRequest
import com.wogoo.mercatopoke.model.PokeModel
import com.wogoo.mercatopoke.repository.PokeRepository
import org.springframework.stereotype.Service

@Service
class PokeService(
    val pokeRepository: PokeRepository
) {
    fun create(poke: PokeModel) {
        pokeRepository.save(poke)
    }

}
