package com.wogoo.mercatopoke.controller

import com.wogoo.mercatopoke.controller.request.PostCustomerRequest
import com.wogoo.mercatopoke.controller.request.PutCustomerRequest
import com.wogoo.mercatopoke.controller.response.CustomerResponse
import com.wogoo.mercatopoke.extension.toCustomerModel
import com.wogoo.mercatopoke.extension.toResponse
import com.wogoo.mercatopoke.security.UserCanOnlyAcessTheirOwnResource
import com.wogoo.mercatopoke.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    @UserCanOnlyAcessTheirOwnResource
    fun getCustumer(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid customer: PutCustomerRequest) {
        val customerSaved = customerService.findById(id)
        return customerService.update(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }

}