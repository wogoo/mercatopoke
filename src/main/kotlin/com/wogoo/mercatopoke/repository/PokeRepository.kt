package com.wogoo.mercatopoke.repository

import com.wogoo.mercatopoke.enums.PokeStatus
import com.wogoo.mercatopoke.model.CustomerModel
import com.wogoo.mercatopoke.model.PokeModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface PokeRepository: JpaRepository<PokeModel, Int> {
     fun findByStatus(status: PokeStatus, pageable: Pageable): Page<PokeModel>
     fun findByCustomer(customer: CustomerModel): List<PokeModel>

//     fun findAll(pageable: Pageable): Page<PokeModel>

}