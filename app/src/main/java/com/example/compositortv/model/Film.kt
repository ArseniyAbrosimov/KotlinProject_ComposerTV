package com.example.compositortv.model

data class Film(
    val kinopoiskId: Int,
    val nameRu: String?,
    val posterUrl: String,
    val posterUrlPreview: String,
    val coverUrl: String?,
    val logoUrl: String?,
    val ratingImdb: Double?,
    val ratingImdbVoteCount: Int?,
    val ratingFilmCritics: Double?,
    val ratingFilmCriticsVoteCount: Int?,
    val year: Int?,
    val filmLength: Int?,
    val description: String?,
    val productionStatus: ProductionStatus?,
    val type: FilmType,
    val ratingAgeLimits: String?,
    val genres: List<Genre>,
    val completed: Boolean?,
) {
    data class Genre(
        val genre: String,
    )

    enum class ProductionStatus {
        FILMING,
        PRE_PRODUCTION,
        COMPLETED,
        ANNOUNCED,
        UNKNOWN,
        POST_PRODUCTION,
    }

    enum class FilmType {
        FILM,
        VIDEO,
        TV_SERIES,
        MINI_SERIES,
        TV_SHOW,
    }
}
