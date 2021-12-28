package com.wogoo.mercatopoke.exception

class BadRequestException(override val message: String, val errorCode: String): Exception() {
}