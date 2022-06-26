@file:OptIn(ExperimentalContracts::class)

package com.godgod.feature.intent.state

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed interface ViewState

@OptIn(ExperimentalContracts::class)
fun ViewState.isMainViewState() : Boolean {
    contract {
        returns(true) implies (this@isMainViewState is MainViewState)
    }

    return when(this) {
        is MainViewState -> true
        else -> false
    }
}