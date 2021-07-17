package com.example.mvvmdemo

import com.example.mvvmdemo.base.BaseViewModel
import com.example.mvvmdemo.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

}
