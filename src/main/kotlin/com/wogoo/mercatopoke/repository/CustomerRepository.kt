package com.wogoo.mercatopoke.repository

import com.wogoo.mercatopoke.model.CustomerModel
import org.springframework.data.repository.CrudRepository


interface CustomerRepository : CrudRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>
}