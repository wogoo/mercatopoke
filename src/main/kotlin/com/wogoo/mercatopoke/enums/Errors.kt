package com.wogoo.mercatopoke.enums

enum class Errors(val code: String, val message: String) {

    MP000("MP-000","Acess Denied"),
    MP1001("MP-1001", "Invalid Request"),
    MP2001("MP-2001", "Poke [%s] not exist"),
    MP2002("MP-2002","Cannot update poke with status [%s]"),
    MP2101("MP-2101", "Customer [%s] not exists")

}