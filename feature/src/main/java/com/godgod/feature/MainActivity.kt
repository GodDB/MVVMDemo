package com.godgod.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import com.godgod.feature.base.GeneralAdapter
import com.godgod.feature.base.GeneralViewHolder
import com.godgod.feature.databinding.ActivityMainBinding
import com.godgod.feature.databinding.ViewholderMovieItemBinding
import com.godgod.shared.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupMovieList()
        observeState()
        observeSideEffect()
    }

    private fun setupMovieList() {
        binding.partialMovies.rvList.adapter = GeneralAdapter<Movie>(
            viewholderFactory = { _, parent ->
                val binding = ViewholderMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).apply {
                    root.apply {
                        post { setOnClickListener { viewModel.setEvent(MainViewEvent.ClickMovieItem(data?.id ?: 0)) } }
                    }
                }
                GeneralViewHolder(binding)
            },
            diffUtil = object : DiffUtil.ItemCallback<Movie>() {
                override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem == newItem
            }
        )
    }

    private fun observeState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                binding.setVariable(BR.state, state)
            }
        }
    }

    private fun observeSideEffect() {
        lifecycleScope.launchWhenStarted {
            viewModel.sideEffect.collect { sideEffect ->
                when (sideEffect) {
                    is MainViewSideEffect.ErrorMessage -> {
                        Toast.makeText(this@MainActivity, sideEffect.errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}