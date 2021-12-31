package com.wogoo.mercatopoke.service

import com.wogoo.mercatopoke.enums.CustomerStatus
import com.wogoo.mercatopoke.enums.Errors
import com.wogoo.mercatopoke.enums.Profile
import com.wogoo.mercatopoke.exception.NotFoundException
import com.wogoo.mercatopoke.model.CustomerModel
import com.wogoo.mercatopoke.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val pokeService: PokeService
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        val customerCopy = customer.copy(
            roles = setOf(Profile.CUSTOMER)
        )
        customerRepository.save(customerCopy)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow { NotFoundException(Errors.MP2101.message.format(id), Errors.MP2101.code) }
    }

    fun update(customer: CustomerModel) {

        if(!customerRepository.existsById(customer.id!!)){
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        pokeService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO

        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
       return !customerRepository.existsByEmail(email)
    }


}