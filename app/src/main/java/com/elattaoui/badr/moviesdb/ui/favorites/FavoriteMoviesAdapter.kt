package com.elattaoui.badr.moviesdb.ui.favorites

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.databinding.ItemMovieViewBinding
import com.elattaoui.badr.moviesdb.ui.views.MovieView

@SuppressLint("NotifyDataSetChanged")
class FavoriteMoviesAdapter(private val moviesList: ArrayList<Movie>) :
        RecyclerView.Adapter<FavoriteMoviesAdapter.FavoriteMovieItemViewHolder>() {

    inner class FavoriteMovieItemViewHolder(private val movieItemBinding: ItemMovieViewBinding) :
            RecyclerView.ViewHolder(movieItemBinding.root) {

        fun bind(movie: Movie) {
            movieItemBinding.root.bind(MovieView.MovieViewData((movie))) {}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieItemViewHolder {
        return FavoriteMovieItemViewHolder(
            ItemMovieViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteMovieItemViewHolder, position: Int) {
        val movieItem = moviesList[position]
        holder.bind(movieItem)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


    fun setMoviesList(movies: List<Movie>) {
        moviesList.apply {
            clear()
            addAll(movies)
            notifyDataSetChanged()
        }
    }

}
