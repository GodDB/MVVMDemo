package com.godgod.feature.ui.movie_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.godgod.domain.model.MovieDetail
import com.godgod.feature.R
import com.godgod.feature.base.BaseFragment
import com.godgod.feature.databinding.FragmentMovieListBinding
import com.godgod.feature.extension.FragmentExt.repeatOnStartToOnStop
import com.godgod.feature.extension.FragmentExt.startSharedElementTransition
import com.godgod.feature.intent.sideEffect.MainViewSideEffect
import com.godgod.feature.ui.movie_list.data.MovieViewData
import com.godgod.feature.util.CommonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val viewModel by viewModels<MovieListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MovieListScreen(viewModel = viewModel)
            }
        }
    }

/*

    override fun setup() {
        setupList()
        initBinding {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            onClickMovieDetail = viewModel.onClickMovieDetail
        }
        startSharedElementTransition()
    }

    private fun setupList() {
        binding.partialMovies.rvList.adapter = CommonAdapter.buildOf<MovieViewData>(
            viewHolderFactory = { parent, _ -> MovieListViewHolder.create(parent, viewModel.onClickMovieItem) },
            areItemsTheSame = { old, new -> old.id == new.id },
            areContentsTheSame = { old, new -> old == new }
        )
    }

    override fun observeViewModel() {
        repeatOnStartToOnStop {
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
*/


}