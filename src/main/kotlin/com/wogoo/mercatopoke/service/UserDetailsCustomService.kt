package com.wogoo.mercatopoke.service

import com.wogoo.mercatopoke.exception.AuthenticationException
import com.wogoo.mercatopoke.repository.CustomerRepository
import com.wogoo.mercatopoke.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val customerRepository: CustomerRepository
): UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val customer =
            customerRepository.findById(id.toInt())
                .orElseThrow { AuthenticationException("user not found", "1111") }
        return UserCustomDetails(customer)
    }
}