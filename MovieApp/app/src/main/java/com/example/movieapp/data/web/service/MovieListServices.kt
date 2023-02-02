package com.example.movieapp.data.web.service

import com.example.movieapp.Constant
import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.data.web.model.moviedetail.MovieDetailResponse
import com.example.movieapp.data.web.model.moviedetail.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieListServices {
   @GET("movie/popular")
   suspend fun getMovies(
       @Query("page")
       pageNumber: Int = 1,
       @Query("api_key")
       apiKey: String = Constant.API_KEY
   ): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: String,
        @Query("api_key") apiKey: String = Constant.API_KEY,
    ): MovieDetailResponse




}