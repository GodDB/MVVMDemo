package com.godgod.feature.extension

import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object FragmentExt {

    inline fun Fragment.repeatFromStartToStop(crossinline block : suspend CoroutineScope.() -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                this.block()
            }
        }
    }

    fun Fragment.startSharedElementTransition() {
        postponeEnterTransition()
        this.view?.doOnPreDraw {
            startPostponedEnterTransition()
        } ?: startPostponedEnterTransition()
    }
}