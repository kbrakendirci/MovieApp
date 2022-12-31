package com.example.movieapp.domain.usecase

import com.example.movieapp.core.TestConstants
import com.example.movieapp.domain.repository.MovieListNetworkRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class GetMoviesDetailsUseCaseTest{

    lateinit var getMoviesDetailsUseCase: GetMoviesDetailsUseCase

    @Mock
    lateinit var mockMoviesRepository: MovieListNetworkRepository

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mockMoviesRepository = Mockito.mock(MovieListNetworkRepository::class.java)
        getMoviesDetailsUseCase = GetMoviesDetailsUseCase(mockMoviesRepository)
    }

    /*
    @Test
    fun testGetMovieSuccess(): Unit = runBlocking{
        val movieDetails = getMoviesDetailsUseCase
        Truth.assertThat((movieDetails.toData()?.id?.equals(1))).isTrue()
    }*/
}