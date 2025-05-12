package com.example.composertv.data

import com.example.composertv.network.ConverterApiService
import com.example.composertv.model.Film

interface ComposerRepository {
    suspend fun getFilmById(id: Int): Film
}


class DefaultComposerRepository(
    private val converterApiService: ConverterApiService
) : ComposerRepository {
    override suspend fun getFilmById(id: Int): Film = converterApiService.getFilmById(id)
}