package com.example.movieapp.ui.listmovie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.UseCaseState
import com.example.movieapp.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
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
    }
}