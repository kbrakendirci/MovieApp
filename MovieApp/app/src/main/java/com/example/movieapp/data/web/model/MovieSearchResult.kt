package com.example.movieapp.data.web.model

data class MovieSearchResult(
    val Response: String,
    var Search: List<Movie>?,
    val totalResults: String?
)