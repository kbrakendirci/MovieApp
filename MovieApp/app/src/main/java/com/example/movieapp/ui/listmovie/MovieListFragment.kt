package com.example.movieapp.ui.listmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.movieapp.BaseFragment
import com.example.movieapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : BaseFragment() {

   private val viewModel: MovieListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupUI()
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    private fun setupUI() {
        viewModel.getMovieListUseCaseState()
    }
}