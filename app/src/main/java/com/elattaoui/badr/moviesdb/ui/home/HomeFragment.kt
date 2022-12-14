package com.elattaoui.badr.moviesdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.elattaoui.badr.moviesdb.R
import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.data.response.MoviesResult
import com.elattaoui.badr.moviesdb.databinding.FragmentHomeBinding
import com.elattaoui.badr.moviesdb.ui.views.MovieView
import com.elattaoui.badr.moviesdb.utils.EndlessRecyclerViewScrollListener
import com.elattaoui.badr.moviesdb.utils.GridEqualSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeFragmentViewModel by viewModels<HomeFragmentViewModel>()
    private val moviesListAdapter: MoviesListAdapter by lazy {
        MoviesListAdapter { movie, movieViewAction ->
            handleMovieAction(movie, movieViewAction)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMoviesList()
        homeFragmentViewModel.fetchPopularMovies(1)
        homeFragmentViewModel.movies.observe(viewLifecycleOwner) { moviesResult ->
            when (moviesResult) {
                is MoviesResult.Loading -> {}
                is MoviesResult.Error -> {
                    Timber.e(moviesResult.exception)
                    Toast.makeText(
                        requireContext(),
                        "Something wrong !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is MoviesResult.Success -> {
                    moviesListAdapter.setMoviesList(moviesResult.data)
                }
            }
        }
        homeFragmentViewModel.updatedMovie.observe(viewLifecycleOwner) { updatedMovie ->
            updatedMovie?.let { movie ->
                moviesListAdapter.updateMovie(movie)
            }
        }
    }

    private fun setupMoviesList() {
        val itemSpacing = resources.getDimension(R.dimen.movie_item_spacing)
        val itemDecoration = GridEqualSpaceItemDecoration(itemSpacing.toInt())
        val recyclerViewLayoutManager = GridLayoutManager(
            requireContext(),
            2
        ).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (moviesListAdapter.getItemViewType(position)) {
                        MoviesListAdapter.TYPE_ITEM -> 1
                        else -> 2
                    }
                }
            }
        }
        binding.moviesRecycler.apply {
            adapter = moviesListAdapter
            layoutManager = recyclerViewLayoutManager
            if (itemDecorationCount == 0) {
                addItemDecoration(itemDecoration)
            }
            addOnScrollListener(object :
                    EndlessRecyclerViewScrollListener(recyclerViewLayoutManager) {
                override fun onLoadMore(page: Int) {
                    homeFragmentViewModel.fetchPopularMovies(page)
                }
            })
        }
    }

    private fun handleMovieAction(movie: Movie, movieViewAction: MovieView.MovieViewAction) {
        when (movieViewAction) {
            MovieView.MovieViewAction.CLICK_MOVIE -> {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movie.id)
                findNavController().navigate(action)
            }
            else -> {
                homeFragmentViewModel.handleFavoriteMovie(movie)
            }
        }
    }
}
