package com.wogoo.mercatopoke.service

import com.wogoo.mercatopoke.controller.request.PostPokeRequest
import com.wogoo.mercatopoke.enums.PokeStatus
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

    fun findAll(): List<PokeModel> {
       return pokeRepository.findAll().toList()
    }

    fun findActives(): List<PokeModel> {
        return pokeRepository.findByStatus(PokeStatus.ATIVO)
    }

    fun findById(id: Int): PokeModel {
        return pokeRepository.findById(id).get()
    }

    fun delete(id: Int) {
        val poke = findById(id)

        poke.status = PokeStatus.CANCELADO
        update(poke)
    }

    fun update(poke: PokeModel) {
        pokeRepository.save(poke)
    }

}
