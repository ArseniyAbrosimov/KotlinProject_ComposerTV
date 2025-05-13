package com.example.composertv.data

import com.example.composertv.model.Film
import com.example.composertv.model.FilmCollectionResponse
import com.example.composertv.network.ComposerApiService

interface ComposerRepository {
    suspend fun getFilmById(id: Int): Film

    suspend fun getNewest(page: Int = 1): FilmCollectionResponse
}

class DefaultComposerRepository(
    private val converterApiService: ComposerApiService,
) : ComposerRepository {
    override suspend fun getFilmById(id: Int): Film = converterApiService.getFilmById(id)

    override suspend fun getNewest(page: Int): FilmCollectionResponse = converterApiService.getNewest(page = page)
}
