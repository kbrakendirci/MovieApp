package com.example.movieapp.data.web.model

data class MovieListResponse(
    //val dates: Dates,
    val page: Int,
    val results: MutableList<MovieListResponse>,
    val total_pages: Int,
    val total_results: Int
)