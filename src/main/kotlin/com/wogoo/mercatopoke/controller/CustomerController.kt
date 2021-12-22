package com.wogoo.mercatopoke.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @GetMapping
    fun hello(): String {
        return "Hello"
    }


}