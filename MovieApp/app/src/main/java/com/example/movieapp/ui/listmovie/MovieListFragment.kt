package com.example.movieapp.ui.listmovie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.BaseFragment
import com.example.movieapp.ListAdapterListener
import com.example.movieapp.data.web.model.Movie
import com.example.movieapp.data.web.model.deneme.OnBoard
import com.example.movieapp.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.SharedFlow

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate), ListAdapterListener<Movie> {

    private val viewModel: MovieListViewModel by viewModels()

        private fun setupAdapter() {
            binding.onBoardCardView.adapter = productListAdapter
        }

        private val productListAdapter by lazy {
            MovieListFragmentAdapter(this)
        }

    override fun setupUI(savedInstanceState: Bundle?) {
       val a=  viewModel.getMovieListUseCaseState()
        setupAdapter()
        var dataList = mutableListOf<OnBoard>()

        //add data
        dataList.add(OnBoard("Summer Party Time","https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/2aa71041442859.57a62518bfab2.jpg"))
        dataList.add(OnBoard("Burn by Tiesto","https://dancingastronaut.com/wp-content/uploads/2015/06/spotify-burn-by-tiesto.jpg",))
        dataList.add(OnBoard("Tekrar Tekrar","https://daily-mix.scdn.co/covers/on_repeat/PZN_On_Repeat2_LARGE-en.jpg",))


    }


}