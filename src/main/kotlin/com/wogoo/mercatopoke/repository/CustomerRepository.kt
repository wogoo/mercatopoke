package com.wogoo.mercatopoke.repository

import com.wogoo.mercatopoke.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository


interface CustomerRepository : JpaRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): CustomerModel?
}