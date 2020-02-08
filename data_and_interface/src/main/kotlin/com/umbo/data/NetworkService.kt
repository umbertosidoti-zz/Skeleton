package com.umbo.data

interface NetworkService {
    fun photos(): Outcome<List<Photo>>
}