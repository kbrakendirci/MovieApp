package com.example.movieapp.ui.listmovie

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.example.movieapp.BaseFragment
import com.example.movieapp.ListAdapterListener
import com.example.movieapp.UseCaseState
import com.example.movieapp.data.web.model.Movie
import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate){

    private val viewModel: MovieListViewModel by viewModels()

        private fun setupAdapter() {
            binding.onBoardCardView.adapter = movieListAdapter
        }

        private val movieListAdapter by lazy {
            MovieListFragmentAdapter()
        }

    override fun setupUI(savedInstanceState: Bundle?) {
         setupAdapter()
        viewModel.listLiveData.observe(this){
            handleMovieList(it)
        }
        viewModel.getMovieListUseCaseState()
        movieListAdapter.setOnItemClickListener {
            // Do it navigation in here
        }
    }

    private fun handleMovieList(status: UseCaseState<MovieListResponse>) {
        when (status) {
            is UseCaseState.Error -> {
                // close the loading view
            }
            is UseCaseState.Success -> {
                movieListAdapter.differ.submitList(status?.data?.results)
            }
            else -> {
                // close the loading view
            }
        }
    }
}