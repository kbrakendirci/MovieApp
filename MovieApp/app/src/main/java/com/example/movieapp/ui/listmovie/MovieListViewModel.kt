package com.example.movieapp.ui.listmovie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.UseCaseState
import com.example.movieapp.data.web.model.MovieSearchResult
import com.example.movieapp.domain.usecase.GetMovieListUseCase
import com.example.movieapp.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase

    ) : ViewModel() {


    fun getMovieListUseCaseState(){
        viewModelScope.launch {
            getMovieListUseCase.invoke().collect{
                when(it){
                    is UseCaseState.Error -> {
                       Log.i(it.message,"")
                    }
                    is UseCaseState.Success->{
                             Log.i(it.message,"")
                    }
                }
            }
        }
    }}
/*

    val response = MutableLiveData<Response<MovieSearchResult>>()
    fun getMovies(name: String, index: Int) {
        response.value = Response.loading(null)
        getMoviesListUseCase.execute(ListParams(name = name, index = index),
            onSuccess = {
                Log.d("DD", "onSuccess" + it.toString())
                response.value = parseResponse(it)
            },
            onError = {
                Log.d("DD", "onError" + it.toString())
                response.value =
                    Response.error(data = null, message = it.message ?: "Error Occurred!")
            }
        )
    }

    private fun parseResponse(result: MovieSearchResult): Response<MovieSearchResult> {
        return if (result.Response.contentEquals("True") && !result.Search.isNullOrEmpty()) {
            Response.success(data = result)
        } else {
            Response.error(data = null, message = "Movie not found!")
        }
    }
    */
