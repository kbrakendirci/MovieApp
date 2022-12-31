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
class MovieListFragment : BaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate) {

    private val viewModel: MovieListViewModel by viewModels()

        private fun setupAdapter() {
            binding.onBoardCardView.adapter = movieListAdapter
        }

        private val movieListAdapter by lazy {
            MovieListFragmentAdapter()
        }

    override fun setupUI(savedInstanceState: Bundle?) {
         viewModel.getMovieListUseCaseState()

        viewModel.listLiveData.observe(this){
            it?.let { ::handleMovieList }
        }

        movieListAdapter.setOnItemClickListener {
            // Do it navigation in here
        }
    }

    private fun handleMovieList(status: LiveData<UseCaseState<MovieListResponse>>) {
        when (status.value) {
            is UseCaseState.Error -> {
                // close the loading view
            }
            is UseCaseState.Success -> {
                setupAdapter()
                movieListAdapter.differ.submitList(status?.value?.data?.results)
            }
            else -> {
                // close the loading view
            }
        }
    }


}