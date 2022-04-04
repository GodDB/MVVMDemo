package com.godgod.feature.ui.movie_detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.godgod.feature.R
import com.godgod.feature.base.BaseFragment
import com.godgod.feature.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>(R.layout.fragment_movie_detail) {

    private val viewModel by viewModels<MovieDetailViewModel>()

    private val args : MovieDetailFragmentArgs by navArgs()
    override fun setup() {
        viewModel
    }
}