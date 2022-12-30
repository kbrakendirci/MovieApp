package com.example.movieapp.data.web.repository

import android.security.identity.ResultData
import com.example.movieapp.data.web.model.Movie
import com.example.movieapp.data.web.model.MovieListRequest
import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.data.web.model.moviedetail.MovieDetails
import com.example.movieapp.data.web.service.MovieListServices
import com.example.movieapp.domain.repository.MovieListNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieListNetworkRepositoryImpl @Inject constructor(
    private val movieListServices : MovieListServices
) : MovieListNetworkRepository {
    override suspend fun getMovies(): MovieListRequest = withContext(Dispatchers.IO){
        movieListServices.getMovies()
    }

    override suspend fun getMovieDetails(movieId: String): MovieDetails {
        return movieListServices.getMovieDetails(id = movieId)
    }
}

