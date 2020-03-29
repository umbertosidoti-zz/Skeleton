package com.umbo.domain.mapper

interface Mapper<T, S> {
    fun map(input: T): S
}