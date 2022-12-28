package com.example.movieapp.data.web.model

import androidx.room.PrimaryKey

data class Movie(
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>? = null,
    var genres: List<Genre>,
    var spoken_languages: List<SpokenLanguage>?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val status: String?,
    val tagline: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)
