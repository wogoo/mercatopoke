package com.wogoo.mercatopoke.repository

import com.wogoo.mercatopoke.enums.PokeStatus
import com.wogoo.mercatopoke.model.PokeModel
import org.springframework.data.repository.CrudRepository

interface PokeRepository: CrudRepository<PokeModel, Int> {
     fun findByStatus(status: PokeStatus): List<PokeModel>

}