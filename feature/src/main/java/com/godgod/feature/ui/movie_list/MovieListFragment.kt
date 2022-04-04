package com.godgod.feature.ui.movie_list

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.godgod.domain.model.Movie
import com.godgod.feature.BR
import com.godgod.feature.R
import com.godgod.feature.base.BaseFragment
import com.godgod.feature.databinding.FragmentMovieListBinding
import com.godgod.feature.extension.FragmentExt.repeatOnStarted
import com.godgod.feature.intent.event.MainViewEvent
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
        }
    }

    override fun observeViewModel() {
        repeatOnStarted {
            viewModel.state.collect { state ->
                binding.setVariable(BR.state, state)
            }
        }


        repeatOnStarted {
            viewModel.sideEffect.collect { sideEffect ->
                when (sideEffect) {
                    is MainViewSideEffect.ErrorMessage -> {
                        Toast.makeText(requireContext(), sideEffect.errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun onClickMovieDetail(v : View) {

    }
}