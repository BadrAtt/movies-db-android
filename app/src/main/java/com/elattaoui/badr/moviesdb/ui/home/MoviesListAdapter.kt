package com.elattaoui.badr.moviesdb.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.databinding.ItemLoaderViewBinding
import com.elattaoui.badr.moviesdb.databinding.ItemMovieViewBinding
import com.elattaoui.badr.moviesdb.ui.views.MovieView


@SuppressLint("NotifyDataSetChanged")
class MoviesListAdapter :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var moviesList = arrayListOf<Movie>()

    companion object {
        const val TYPE_ITEM = 0
        const val TYPE_LOADER = 1
    }

    inner class MovieItemViewHolder(private val movieItemView: ItemMovieViewBinding) :
            RecyclerView.ViewHolder(movieItemView.root) {

        fun bind(movie: Movie) {
            movieItemView.root.bind(MovieView.MovieViewData((movie)))
        }
    }

    inner class LoaderViewHolder(private val loaderItemView: ItemLoaderViewBinding) :
            RecyclerView.ViewHolder(loaderItemView.root) {
        fun bind() {
            loaderItemView.root.setIndeterminate(true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_ITEM -> {
                return MovieItemViewHolder(
                    ItemMovieViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                return LoaderViewHolder(
                    ItemLoaderViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MovieItemViewHolder -> {
                val movieItem = moviesList[position]
                holder.bind(movieItem)
            }
            is LoaderViewHolder -> holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position != moviesList.size) {
            TYPE_ITEM
        } else {
            TYPE_LOADER
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size + 1
    }

    fun setMoviesList(movies: List<Movie>) {
        this.moviesList.addAll(movies)
        notifyDataSetChanged()
    }
}
