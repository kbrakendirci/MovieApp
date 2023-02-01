package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.repository.MovieListNetworkRepository
import javax.inject.Inject
import com.example.movieapp.UseCaseState
import com.example.movieapp.data.web.model.moviedetail.MovieDetails
import kotlinx.coroutines.flow.flow


class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieListNetworkRepository
) {
    suspend fun execute(movieId: String) = flow <UseCaseState<MovieDetails>> {
        try {
            emit(UseCaseState.Success(repository.getMovieDetails(id = movieId)))
        } catch (e: Exception) {
            emit(UseCaseState.Error(e.message.toString()))
        }
    }
}