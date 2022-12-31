package com.example.movieapp.data.web.model

data class MovieList(
    //val dates: Dates,
    val page: Int,
    val results: MutableList<Movie>,
    val total_pages: Int,
    val total_results: Int
)