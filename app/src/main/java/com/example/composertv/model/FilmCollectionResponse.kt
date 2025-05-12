package com.example.composertv.model

data class FilmCollectionResponse (
    val total: Int,
    val totalPages: Int,
    val items: List<FilmCollectionResponseItems>
) {
    data class FilmCollectionResponseItems(
        val kinopoiskId: Int,
        val nameRu: String,
        val posterUrlPreview: String
    )
}