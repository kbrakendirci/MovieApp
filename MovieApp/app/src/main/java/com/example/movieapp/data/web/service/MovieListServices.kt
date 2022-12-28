package com.example.movieapp.data.web.service

import com.example.movieapp.Constant
import com.example.movieapp.data.web.model.MovieListRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieListServices {
   /* @GET("movie/popular")
    fun getMovieList(
        @Query("api_key")key: String,
        @Query("query")query :String,
        @Query("page") page:Int):Call<MovieListRequest>
*/
   @GET("movie/popular")
   suspend fun getMovies(
       @Query("page")
       pageNumber: Int = 1,
       @Query("api_key")
       apiKey: String = Constant.API_KEY
   ): MovieListRequest

}