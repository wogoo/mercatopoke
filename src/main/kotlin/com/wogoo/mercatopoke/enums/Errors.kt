package com.wogoo.mercatopoke.enums

enum class Errors(val code: String, val message: String) {

    MP2001("MP-2001", "Poke [%s] not exist"),
    MP2002("MP-2002","Cannot update poke with status [%s]"),
    MP2101("MP-2101", "Customer [%s] not exists")

}