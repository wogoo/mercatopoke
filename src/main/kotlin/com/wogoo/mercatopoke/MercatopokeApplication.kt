package com.wogoo.mercatopoke

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class MercatopokeApplication

fun main(args: Array<String>) {
	runApplication<MercatopokeApplication>(*args)
}
