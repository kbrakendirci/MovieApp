package com.example.movieapp.ui.listmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.Constant
import com.example.movieapp.R
import com.example.movieapp.data.web.model.MovieListResponse
import kotlinx.android.synthetic.main.item_movielist.view.*

class MovieListFragmentAdapter: RecyclerView.Adapter<MovieListFragmentAdapter.MovieListFragmentViewHolder>() {

    class MovieListFragmentViewHolder(view: View): RecyclerView.ViewHolder(view)


    private val differCallback = object : DiffUtil.ItemCallback<MovieListResponse.Result>(){
        override fun areItemsTheSame(
            oldItem: MovieListResponse.Result,
            newItem: MovieListResponse.Result
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: MovieListResponse.Result,
            newItem: MovieListResponse.Result
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListFragmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.movie_list_item, parent, false)
        return MovieListFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListFragmentViewHolder, position: Int) {
        val listItem = differ.currentList[position]
        holder.itemView.apply {
            txtMovieTitle.text= listItem.title
            //voteTextView.text= listItem.voteAverage.toString()
            Glide.with(this)
                .apply { RequestOptions().override(120, 120).fitCenter() }
                .load(Constant.POSTER_BASE_URL+listItem.backdropPath)
                .into(imagePoster)
            rootView.setOnClickListener {
                onItemClickListener?.invoke(listItem.id.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }
}


