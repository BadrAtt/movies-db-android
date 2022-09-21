package com.elattaoui.badr.moviesdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.elattaoui.badr.moviesdb.R
import com.elattaoui.badr.moviesdb.databinding.FragmentHomeBinding
import com.elattaoui.badr.moviesdb.utils.GridEqualSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeFragmentViewModel by viewModels<HomeFragmentViewModel>()
    private val moviesListAdapter: MoviesListAdapter by lazy {
        MoviesListAdapter(listOf())
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
        homeFragmentViewModel.movies.observe(viewLifecycleOwner) { moviesList ->
            moviesListAdapter.setMoviesList(moviesList)
        }
    }

    private fun setupMoviesList() {
        val itemSpacing = resources.getDimension(R.dimen.movie_item_spacing)
        val itemDecoration = GridEqualSpaceItemDecoration(itemSpacing.toInt())
        val recyclerViewLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.moviesRecycler.apply {
            adapter = moviesListAdapter
            layoutManager = recyclerViewLayoutManager
            if (itemDecorationCount == 0) {
                addItemDecoration(itemDecoration)
            }
        }
    }
}
