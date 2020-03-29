package com.umbo.presentation.core

interface Mapper<T, S> {
    fun map(input: T): S
}