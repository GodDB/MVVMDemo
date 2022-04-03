package com.godgod.feature.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.godgod.feature.intent.event.ViewEvent
import com.godgod.feature.intent.sideEffect.ViewSideEffect
import com.godgod.feature.intent.state.ViewState
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

    protected fun <T> setState(partialState: T) {
        _state.update {
            viewStateUpdate(it, partialState)
        }
    }

    protected fun <T : ViewSideEffect> setSideEffect(sideEffect: T) {
        viewModelScope.launch {
            _sideEffect.emit(sideEffect)
        }
    }

    protected abstract fun <T> viewStateUpdate(prevState: ViewState, partialState: T): ViewState

    protected abstract suspend fun handleEvent(viewEvent: ViewEvent)


}