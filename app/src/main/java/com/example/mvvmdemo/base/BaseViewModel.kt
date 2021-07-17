package com.example.mvvmdemo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _viewEvent: MutableLiveData<Any> = MutableLiveData()
    val viewEvent: LiveData<Any>
        get() = _viewEvent

    fun viewEvent(event: Any) {
        _viewEvent.value = event
    }
}