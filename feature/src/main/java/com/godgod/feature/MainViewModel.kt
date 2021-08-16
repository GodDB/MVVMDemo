package com.godgod.feature

import android.util.Log
import com.example.mvvmdemo.base.BaseViewModel
import com.godgod.domain.MovieDetailUseCase
import com.godgod.domain.MovieListUseCase
import com.godgod.shared.model.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase,
    private val movieDetailUseCase: MovieDetailUseCase
) : BaseViewModel() {

    init {
        CoroutineScope(Dispatchers.Main).launch {
            val movieList = movieListUseCase(Unit)
            Log.d("godgod", "${movieList}")
            val movieDetail = movieDetailUseCase(movieList.data?.get(0)?.id ?: 0)
            Log.d("godgod", "$movieDetail")
        }

    }
}
