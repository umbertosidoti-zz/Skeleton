package com.umbo.network

interface Mapper<T, S> {
    fun map(input: T): S
}