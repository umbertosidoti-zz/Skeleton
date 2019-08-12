package com.umbo.skeleton.core

interface Mapper<T, S> {
    fun map(input: T): S
}