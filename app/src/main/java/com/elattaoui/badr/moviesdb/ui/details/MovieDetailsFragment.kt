package com.elattaoui.badr.moviesdb.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.data.response.MovieDetailsResult
import com.elattaoui.badr.moviesdb.databinding.FragmentMovieDetailsBinding
import com.elattaoui.badr.moviesdb.utils.visibility
import dagger.hilt.android.AndroidEntryPoint

const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/original/"

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private val movieDetailsViewModel by viewModels<MovieDetailsViewModel>()
    private val fragmentArgs by navArgs<MovieDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailsViewModel.fetchMovieDetails(fragmentArgs.movieId)
            .observe(viewLifecycleOwner) { result ->
                when (result) {
                    is MovieDetailsResult.Loading -> {
                        binding.loader.visibility(true)
                    }
                    is MovieDetailsResult.Error -> {
                        binding.loader.visibility(false)
                        Toast.makeText(
                            requireContext(),
                            "Something wrong !",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is MovieDetailsResult.Success -> {
                        binding.loader.visibility(false)
                        displayMovieDetails(result.data)
                    }
                }
            }
    }

    private fun displayMovieDetails(movie: Movie) {
        binding.movieTitle.text = movie.title
        binding.movieOverview.text = movie.overview
        binding.movieReleaseDate.text = movie.releaseDate
        Glide.with(requireContext())
            .load("${POSTER_BASE_URL}${movie.posterPath}")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.moviePoster)
    }
}
