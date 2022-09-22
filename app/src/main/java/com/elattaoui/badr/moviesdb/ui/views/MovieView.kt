package com.elattaoui.badr.moviesdb.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
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

    fun bind(data: MovieViewData) {
        binding.movieRating.text = "${data.movie.voteAverage}"
        binding.raters.text = "${data.movie.voteCount}"
        binding.movieTitle.text = data.movie.title

        Glide.with(context)
            .load("$POSTER_BASE_URL${data.movie.posterPath}")
            .into(binding.moviePoster)

    }

    data class MovieViewData(val movie: Movie)
    companion object {
        private const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    }
}
