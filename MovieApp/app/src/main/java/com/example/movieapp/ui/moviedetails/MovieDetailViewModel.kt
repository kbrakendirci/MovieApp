package com.example.movieapp.ui.moviedetails

import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel(){
}