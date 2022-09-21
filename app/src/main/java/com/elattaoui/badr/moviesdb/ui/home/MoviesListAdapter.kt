package com.elattaoui.badr.moviesdb.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elattaoui.badr.moviesdb.databinding.ItemMovieViewBinding
import com.elattaoui.badr.moviesdb.ui.data.model.Movie
import com.elattaoui.badr.moviesdb.ui.views.MovieView

@SuppressLint("NotifyDataSetChanged")
class MoviesListAdapter(private var moviesList: List<Movie>) :
        RecyclerView.Adapter<MoviesListAdapter.MovieItemViewHolder>() {

    inner class MovieItemViewHolder(private val movieItemView: ItemMovieViewBinding) :
            RecyclerView.ViewHolder(movieItemView.root) {

        fun bind(movie: Movie) {
            movieItemView.root.bind(MovieView.MovieViewData((movie)))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(
            ItemMovieViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val movieItem = moviesList[position]
        holder.bind(movieItem)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setMoviesList(movies: List<Movie>) {
        this.moviesList = movies
        notifyDataSetChanged()
    }
}
