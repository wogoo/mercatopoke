package com.wogoo.mercatopoke.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}