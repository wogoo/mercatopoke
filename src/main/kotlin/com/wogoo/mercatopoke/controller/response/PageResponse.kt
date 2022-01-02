package com.wogoo.mercatopoke.controller.response

data class PageResponse<T>(
    var items: List<T>,
    var currentPage: Int,
    var totalItems: Long,
    var totalPage: Int
)