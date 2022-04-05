package com.godgod.feature.ui.movie_list

import android.os.Bundle
import android.transition.TransitionInflater
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.godgod.domain.model.MovieDetail
import com.godgod.feature.BR
import com.godgod.feature.R
import com.godgod.feature.base.BaseFragment
import com.godgod.feature.databinding.FragmentMovieListBinding
import com.godgod.feature.extension.FragmentExt.repeatFromStartToStop
import com.godgod.feature.extension.FragmentExt.startSharedElementTransition
import com.godgod.feature.intent.sideEffect.MainViewSideEffect
import com.godgod.feature.ui.movie_list.data.MovieViewData
import com.godgod.feature.util.CommonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>(R.layout.fragment_movie_list) {

    private val viewModel by viewModels<MovieListViewModel>()

    override fun setup() {
        initBinding {
            lifecycleOwner = viewLifecycleOwner
            adapter = CommonAdapter.buildOf<MovieViewData>(
                viewHolderFactory = { parent, _ -> MovieListViewHolder.create(parent, viewModel.onClickMovieItem) },
                areItemsTheSame = { old, new -> old.id == new.id },
                areContentsTheSame = { old, new -> old == new }
            )
            onClickMovieDetail = viewModel.onClickMovieDetail
        }

        startSharedElementTransition()
    }

    override fun observeViewModel() {
        repeatFromStartToStop {
            viewModel.state.collect { state ->
                binding.setVariable(BR.state, state)
            }
        }


        repeatFromStartToStop {
            viewModel.sideEffect.collect { sideEffect ->
                when (sideEffect) {
                    is MainViewSideEffect.ErrorMessage -> Toast.makeText(requireContext(), sideEffect.errorMessage, Toast.LENGTH_SHORT).show()
                    is MainViewSideEffect.NavigateToMovieDetail -> navigateToMovieDetail(binding.partialDetail.ivDetailThumbnail, sideEffect.movieDetail)
                }
            }
        }
    }

    private fun navigateToMovieDetail(fromView: ImageView, movieDetail: MovieDetail) {
        val transition = FragmentNavigatorExtras(fromView to movieDetail.poster_path)
        val action = MovieListFragmentDirections.actionFragmentMovieListToFragmentMovieDetail(movieDetail)
        findNavController().navigate(action, transition)
    }
}