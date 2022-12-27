package com.example.movieapp.domain.repository
import com.example.movieapp.data.web.model.Movie
import com.example.movieapp.data.web.model.MovieListRequest
import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.data.web.model.PopularMovie
import kotlinx.coroutines.flow.Flow

interface MovieListNetworkRepository {
    //suspend fun getMoviesList(): MovieListRequest
   suspend fun getMovies(): MovieListRequest

}