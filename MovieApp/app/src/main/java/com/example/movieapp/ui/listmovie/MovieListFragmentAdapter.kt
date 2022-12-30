package com.example.movieapp.ui.listmovie

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.ListAdapterListener
import com.example.movieapp.data.web.model.Movie
import com.example.movieapp.databinding.ItemPopulerMovieListBinding
import com.squareup.picasso.Picasso

class MovieListFragmentAdapter(private val listAdapterListener: ListAdapterListener<Movie>) :
    ListAdapter<Movie, MovieListFragmentAdapter.ViewHolder>(ViewHolder.DiffUtils()) {
    private var movieList = mutableListOf<Movie>()

    fun setList(list: Movie) {
            this.movieList.addAll(listOf(list))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listAdapterListener)
    }

    class ViewHolder(private val binding: ItemPopulerMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.N)
        @SuppressLint("ResourceAsColor")
        fun bind(
            movie: Movie,
            listAdapterListener: ListAdapterListener<Movie>
        ) {
            binding.txtMovieTitle.text = movie.title
            Glide.with(itemView)
                .apply { RequestOptions().override(120, 120).fitCenter() }
                .load(movie.poster_path)
                .into(binding.imgMovie)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemPopulerMovieListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolder(binding)
            }
        }

        class DiffUtils : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}