package com.godgod.feature.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _event: MutableSharedFlow<ViewEvent> = MutableSharedFlow()

    protected abstract val initialState: () -> ViewState

    private val _state: MutableStateFlow<ViewState> = MutableStateFlow(initialState())
    val state: StateFlow<ViewState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<ViewSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<ViewSideEffect>
        get() = _sideEffect.asSharedFlow()

    init {
        viewModelScope.launch {
            _event.collect(::handleEvent)
        }
    }

    fun setEvent(event: ViewEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    protected fun<T> setState(partialState : T) {
        val newState = viewStateReduce(_state.value, partialState)
        _state.value = newState
    }

    protected fun<T : ViewSideEffect> setSideEffect(sideEffect : T) {
        viewModelScope.launch {
            _sideEffect.emit(sideEffect)
        }
    }

    protected abstract fun <T> viewStateReduce(prevState: ViewState, partialState: T) : ViewState

    protected abstract fun handleEvent(viewEvent: ViewEvent)


}