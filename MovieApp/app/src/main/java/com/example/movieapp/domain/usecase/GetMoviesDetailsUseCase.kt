package com.example.movieapp.domain.usecase
import com.example.movieapp.UseCaseState
import com.example.movieapp.data.web.model.moviedetail.MovieDetails
import com.example.movieapp.domain.repository.MovieListNetworkRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetMoviesDetailsUseCase @Inject constructor(private val repository: MovieListNetworkRepository )
{
    suspend fun execute(movieId: Params) = flow < UseCaseState<MovieDetails>> {
        try {
            emit(UseCaseState.Success(repository.getMovieDetails(id = movieId.id)))
        } catch (e: Exception) {
            emit(UseCaseState.Error(e.message.toString()))
        }
    }
}

data class Params(
    var id: String
)