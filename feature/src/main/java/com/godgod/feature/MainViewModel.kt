package com.godgod.feature

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.base.BaseViewModel
import com.godgod.domain.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase
) : BaseViewModel() {

    init {
        viewModelScope.launch {
            Log.d("godgod", "${  movieListUseCase(Unit)}")
        }
    }
}
