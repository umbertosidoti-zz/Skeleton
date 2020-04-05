package com.umbo.data

interface ListInteractor {
    suspend fun photos(): Outcome<List<Photo>>
    suspend fun navigationPayload(id: Int): Outcome<NavigationPayload>
}