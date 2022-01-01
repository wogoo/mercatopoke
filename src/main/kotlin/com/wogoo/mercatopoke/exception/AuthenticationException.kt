package com.wogoo.mercatopoke.exception

class AuthenticationException(override val message: String, val errorCode: String): Exception() {
}