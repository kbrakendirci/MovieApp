package com.example.movieapp.domain.repository
import com.example.movieapp.data.web.model.MovieListResponse
import kotlinx.coroutines.flow.Flow

interface MovieListNetworkRepository {
    //suspend fun getMoviesList(): MovieListRequest
   suspend fun getMovies(): MovieListResponse

}