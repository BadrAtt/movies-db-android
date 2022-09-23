package com.elattaoui.badr.moviesdb.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.elattaoui.badr.moviesdb.R
import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.databinding.MovieViewBinding

class MovieView : ConstraintLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding = MovieViewBinding.inflate(LayoutInflater.from(context), this)

    fun bind(data: MovieViewData, callback: (MovieViewAction) -> Unit) {
        binding.movieRating.text = "${data.movie.voteAverage}"
        binding.raters.text = "${data.movie.voteCount}"
        binding.movieTitle.text = data.movie.title

        Glide.with(context)
            .load("$POSTER_BASE_URL${data.movie.posterPath}")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.moviePoster)

        if (data.movie.isFavorite) {
            binding.movieFavoriteBtn.setImageResource(R.drawable.ic_baseline_favorite)
        } else {
            binding.movieFavoriteBtn.setImageResource(R.drawable.ic_outline_favorite)
        }

        binding.moviePoster.setOnClickListener {
            callback.invoke(MovieViewAction.CLICK_MOVIE)
        }
        binding.movieFavoriteBtn.setOnClickListener {
            callback.invoke(MovieViewAction.ADD_TO_FAVORITE)
        }
    }

    data class MovieViewData(val movie: Movie)
    enum class MovieViewAction {
        CLICK_MOVIE,
        ADD_TO_FAVORITE
    }

    companion object {
        private const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    }
}
