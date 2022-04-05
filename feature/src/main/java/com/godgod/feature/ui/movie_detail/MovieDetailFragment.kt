package com.godgod.feature.ui.movie_detail

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.godgod.feature.R
import com.godgod.feature.base.BaseFragment
import com.godgod.feature.databinding.FragmentMovieDetailBinding
import com.godgod.feature.extension.ImageViewExt.setImageUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>(R.layout.fragment_movie_detail) {

    private val viewModel by viewModels<MovieDetailViewModel>()
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }


    override fun setup() {
        initBinding {
            movieDetail = args.movieDetail
        }

        postponeEnterTransition()
        binding.ivThumbnail.setImageUrl(
            imageUrl = args.movieDetail.poster_path,
            onComplete = { startPostponedEnterTransition() }
        )
    }
}