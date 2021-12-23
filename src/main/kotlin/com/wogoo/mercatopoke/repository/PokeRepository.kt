package com.wogoo.mercatopoke.repository

import com.wogoo.mercatopoke.model.PokeModel
import org.springframework.data.repository.CrudRepository

interface PokeRepository: CrudRepository<PokeModel, Int> {

}