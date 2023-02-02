package com.example.movieapp.ui.moviedetails

import android.security.identity.ResultData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.UseCaseState
import com.example.movieapp.data.web.model.moviedetail.MovieDetailResponse
import com.example.movieapp.data.web.model.moviedetail.MovieDetails
import com.example.movieapp.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel(){
    private val _movieDetailsResult = MutableLiveData<UseCaseState<MovieDetailResponse>>()
    val movieDetailsResult : LiveData<UseCaseState<MovieDetailResponse>>
    get() = _movieDetailsResult

    fun getMovieDetails(movieId:String){
        viewModelScope.launch {
            getMovieDetailUseCase.execute(movieId).collect{
                //handleTask(it)
                _movieDetailsResult.postValue(it)
            }
        }
    }
}