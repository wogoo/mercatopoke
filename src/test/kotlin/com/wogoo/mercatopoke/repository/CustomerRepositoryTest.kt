package com.wogoo.mercatopoke.repository

import com.wogoo.mercatopoke.helper.buildCustomer
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerRepositoryTest {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @BeforeEach
    fun setup() = customerRepository.deleteAll()

    @Test
    fun `should return name containing`() {
        val andrew = customerRepository.save(buildCustomer(name = "andrew"))
        val polsen = customerRepository.save(buildCustomer(name = "polsen"))
        val andrea = customerRepository.save(buildCustomer(name = "andrea"))

        val customers = customerRepository.findByNameContaining("an")

        assertEquals(listOf(andrew, andrea), customers)
    }

    @Nested
    inner class `exists by email` {
        @Test
        fun `should return true when email exists`() {
            val email = "ee@exist.com"
            customerRepository.save(buildCustomer(email = email))

            val exists = customerRepository.existsByEmail(email)

            assertTrue(exists)
        }

        @Test
        fun `should return false when email do not exists`() {
            val email = "ee@dontexist.com"


            val exists = customerRepository.existsByEmail(email)

            assertFalse(exists)
        }
    }
    @Nested
    inner class `find by email` {
        @Test
        fun `should return customer when email exists`() {
            val email = "ee@exist.com"
            val customer = customerRepository.save(buildCustomer(email = email))

            val result = customerRepository.findByEmail(email)

            assertNotNull(result)
            assertEquals(customer, result)
        }

        @Test
        fun `should return null when email do not exists`() {
            val email = "ee@dontexist.com"

            val result = customerRepository.findByEmail(email)

            assertNull(result)
        }
    }
}