package com.wogoo.mercatopoke.controller

import com.wogoo.mercatopoke.controller.request.PostCustomerRequest
import com.wogoo.mercatopoke.model.CustomerModel
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController {

    @GetMapping
    fun getCustomer(): CustomerModel {
        return CustomerModel("1", "ALU", "alu@ttt")
    }
    @PostMapping
    fun create(@RequestBody customer: PostCustomerRequest) {
        println(customer)
    }

}