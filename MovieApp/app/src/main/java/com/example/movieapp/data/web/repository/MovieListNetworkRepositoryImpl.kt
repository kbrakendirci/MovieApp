package com.example.movieapp.data.web.repository

import android.security.identity.ResultData
import com.example.movieapp.data.web.model.MovieListRequest
import com.example.movieapp.data.web.model.MovieListResponse
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
    override suspend fun getMovies(): MovieListResponse = withContext(Dispatchers.IO){
        movieListServices.getMovies()
    }
}

