package com.example.movieapp.domain.repository

import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.data.web.model.moviedetail.MovieDetails

interface MovieListNetworkRepository {
    //suspend fun getMoviesList(): MovieListRequest
    suspend fun getMovies(): MovieListResponse
    suspend fun getMovieDetails(id: String): MovieDetails
}