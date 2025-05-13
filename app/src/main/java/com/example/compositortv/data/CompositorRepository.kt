package com.example.compositortv.data

import com.example.compositortv.model.Film
import com.example.compositortv.model.FilmCollectionResponse
import com.example.compositortv.network.CompositorApiService

interface CompositorRepository {
    suspend fun getFilmById(id: Int): Film

    suspend fun getNewest(page: Int = 1): FilmCollectionResponse
}

class DefaultCompositorRepository(
    private val converterApiService: CompositorApiService,
) : CompositorRepository {
    override suspend fun getFilmById(id: Int): Film = converterApiService.getFilmById(id)

    override suspend fun getNewest(page: Int): FilmCollectionResponse = converterApiService.getNewest(page = page)
}
