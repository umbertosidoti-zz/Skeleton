package com.umbo.data

interface Mapper<T, S> {
    fun map(input: T): S
}