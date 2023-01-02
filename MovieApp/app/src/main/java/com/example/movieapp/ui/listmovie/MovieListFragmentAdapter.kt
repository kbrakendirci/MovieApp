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
import kotlinx.android.synthetic.main.item_populer_movie_list.view.*

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
        val view: View = inflater.inflate(R.layout.item_populer_movie_list, parent, false)
        return MovieListFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListFragmentViewHolder, position: Int) {
        val listItem = differ.currentList[position]
        holder.itemView.apply {
            txtMovieTitle.text = listItem.title
            Glide.with(this)
                .apply { RequestOptions().override(120, 120).fitCenter() }
                .load(Constant.POSTER_BASE_URL+listItem.backdropPath)
                .into(imgMovie)
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


    /*: ListAdapter<MovieListResponse.Result, MovieListFragmentAdapter.ViewHolder>(ViewHolder.DiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemPopulerMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.N)
        @SuppressLint("ResourceAsColor")
        fun bind(
            movie: MovieListResponse.Result
        ) {
            binding.txtMovieTitle.text = movie.title
            Glide.with(itemView)
                .apply { RequestOptions().override(120, 120).fitCenter() }
                .load(movie.id)
                .into(binding.imgMovie)

            binding.root.setOnClickListener {

            }
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

        class DiffUtils : DiffUtil.ItemCallback<MovieListResponse.Result>() {
            override fun areItemsTheSame(
                oldItem: MovieListResponse.Result,
                newItem: MovieListResponse.Result
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem:MovieListResponse.Result,
                newItem: MovieListResponse.Result
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

*/