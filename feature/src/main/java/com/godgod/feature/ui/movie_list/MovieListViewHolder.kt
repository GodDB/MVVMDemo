package com.godgod.feature.ui.movie_list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.godgod.domain.model.Movie
import com.godgod.feature.base.BaseViewHolder
import com.godgod.feature.databinding.ViewholderMovieItemBinding
import com.godgod.feature.ui.movie_list.data.MovieViewData

internal class MovieListViewHolder private constructor(
    private val binding: ViewholderMovieItemBinding,
    onClickItem: (MovieViewData) -> Unit
) : BaseViewHolder<MovieViewData>(binding) {

    init {
        binding.onClick = onClickItem
    }

    override fun bind(data: MovieViewData) {
        binding.apply {
            this.data = data
        }.run {
            executePendingBindings()
        }
    }

    companion object {
        fun create(parent: ViewGroup, onClickItem: (MovieViewData) -> Unit): MovieListViewHolder =
            MovieListViewHolder(ViewholderMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), onClickItem)
    }
}