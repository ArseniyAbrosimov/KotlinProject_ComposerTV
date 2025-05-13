package com.example.composertv.network

import com.example.composertv.model.FilmCollectionResponse
import com.example.composertv.model.Film
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

enum class Collection {
    TOP_POPULAR_ALL,
    TOP_POPULAR_MOVIES,
    TOP_250_TV_SHOWS,
    TOP_250_MOVIES,
    VAMPIRE_THEME,
    COMICS_THEME,
    CLOSES_RELEASES,
    FAMILY,
    OSKAR_WINNERS_2021,
    LOVE_THEME,
    ZOMBIE_THEME,
    CATASTROPHE_THEME,
    KIDS_ANIMATION_THEME,
    POPULAR_SERIES
}

interface ComposerApiService {
    @GET("api/v2.2/films/{id}")
    suspend fun getFilmById(@Path("id") id: Int): Film
    @GET("api/v2.2/films/collections")
    suspend fun getNewest(@Query("type") collection: Collection = Collection.CLOSES_RELEASES,
                          @Query("page") page:Int): FilmCollectionResponse
}
