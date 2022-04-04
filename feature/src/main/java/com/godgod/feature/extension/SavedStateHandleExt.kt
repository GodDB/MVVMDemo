package com.godgod.feature.extension

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs

object SavedStateHandleExt {

    inline fun <reified T : NavArgs> SavedStateHandle.asSafeArgs() : T {
        val method = T::class.java.getMethod("fromSavedStateHandle", SavedStateHandle::class.java)
        return method.invoke(null, this) as T
    }

}

