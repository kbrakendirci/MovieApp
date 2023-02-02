package com.example.movieapp.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.movieapp.BaseFragment
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>(FragmentMovieDetailBinding::inflate) {

    private val viewModel : MovieDetailViewModel by viewModels()
    private val args : MovieDetailFragmentArgs by navArgs()

    override fun setupUI(savedInstanceState: Bundle?) {
        viewModel.getMovieDetails(args.movieId.toString())
        setupObserve()
    }

    private fun setupObserve() {
        viewModel.movieDetailsResult.observe(viewLifecycleOwner){

        }
    }


}