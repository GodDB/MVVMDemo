package com.godgod.feature.ui.movie_list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.godgod.domain.model.Movie
import com.godgod.feature.base.BaseViewHolder
import com.godgod.feature.databinding.ViewholderMovieItemBinding

internal class MovieListViewHolder private constructor(
    private val binding: ViewholderMovieItemBinding,
    onClickItem: (Movie) -> Unit
) : BaseViewHolder<Movie>(binding) {

    init {
        binding.onClick = onClickItem
    }

    override fun bind(data: Movie) {
        binding.apply {
            this.data = data
        }.run {
            executePendingBindings()
        }
    }

    companion object {
        fun create(parent: ViewGroup, onClickItem: (Movie) -> Unit): MovieListViewHolder =
            MovieListViewHolder(ViewholderMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), onClickItem)
    }
}