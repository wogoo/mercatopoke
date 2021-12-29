package com.wogoo.mercatopoke.service

import com.wogoo.mercatopoke.enums.Errors
import com.wogoo.mercatopoke.enums.PokeStatus
import com.wogoo.mercatopoke.exception.NotFoundException
import com.wogoo.mercatopoke.model.CustomerModel
import com.wogoo.mercatopoke.model.PokeModel
import com.wogoo.mercatopoke.repository.PokeRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class PokeService(
    val pokeRepository: PokeRepository
) {
    fun create(poke: PokeModel) {
        pokeRepository.save(poke)
    }

    fun findAll(pageable: Pageable): Page<PokeModel> {
       return pokeRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<PokeModel> {
        return pokeRepository.findByStatus(PokeStatus.ATIVO, pageable)
    }

    fun findById(id: Int): PokeModel {
        return pokeRepository.findById(id).orElseThrow { NotFoundException(Errors.MP2001.message.format(id), Errors.MP2001.code)}
    }

    fun delete(id: Int) {
        val poke = findById(id)

        poke.status = PokeStatus.CANCELADO
        update(poke)
    }

    fun update(poke: PokeModel) {
        pokeRepository.save(poke)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val pokes = pokeRepository.findByCustomer(customer)
        for(poke in pokes) {
            poke.status = PokeStatus.DELETADO
        }
        pokeRepository.saveAll(pokes)
    }

    fun finAllByIds(pokesIds: Set<Int>): List<PokeModel> {
        return pokeRepository.findAllById(pokesIds).toList()
    }

}
