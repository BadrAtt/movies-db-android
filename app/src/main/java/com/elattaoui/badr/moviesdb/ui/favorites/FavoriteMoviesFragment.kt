package com.elattaoui.badr.moviesdb.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.elattaoui.badr.moviesdb.R
import com.elattaoui.badr.moviesdb.databinding.FragmentFavoriteMoviesBinding
import com.elattaoui.badr.moviesdb.utils.GridEqualSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteMoviesFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMoviesBinding
    private val favoriteMoviesFragmentViewModel by viewModels<FavoriteMoviesFragmentViewModel>()
    private val favoriteMoviesAdapter by lazy {
        FavoriteMoviesAdapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteMoviesBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFavoriteMoviesList()
        favoriteMoviesFragmentViewModel.getFavoriteMovies().observe(viewLifecycleOwner) {
            favoriteMoviesAdapter.setMoviesList(it)
        }
    }

    private fun setupFavoriteMoviesList() {
        val itemSpacing = resources.getDimension(R.dimen.movie_item_spacing)
        val itemDecoration = GridEqualSpaceItemDecoration(itemSpacing.toInt())
        val recyclerViewLayoutManager = GridLayoutManager(
            requireContext(),
            2
        )
        binding.favoritesRecycler.apply {
            adapter = favoriteMoviesAdapter
            layoutManager = recyclerViewLayoutManager
            if (itemDecorationCount == 0) {
                addItemDecoration(itemDecoration)
            }
        }
    }
}
