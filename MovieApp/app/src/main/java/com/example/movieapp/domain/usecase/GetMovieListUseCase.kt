package com.example.movieapp.domain.usecase
import com.example.movieapp.UseCaseState
import com.example.movieapp.data.web.model.Movie
import com.example.movieapp.data.web.model.MovieListRequest
import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.data.web.model.PopularMovie
import com.example.movieapp.domain.repository.MovieListNetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieListNetworkRepository: MovieListNetworkRepository
) {
    suspend fun invoke() = flow<UseCaseState<MovieListRequest>>{
        try {
            emit(UseCaseState.Success(movieListNetworkRepository.getMovies()))
        } catch (e: Exception) {
            emit(UseCaseState.Error(e.message.toString()))
        }
    }
}