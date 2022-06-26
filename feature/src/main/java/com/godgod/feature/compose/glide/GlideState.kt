package com.godgod.feature.compose.glide

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide

sealed class GlideState {
    object None : GlideState()

    data class Loading(val drawable : Drawable?) : GlideState()

    data class Error(val drawable : Drawable?) : GlideState()

    data class Success(val drawable : Drawable) : GlideState()
}

fun GlideState.getDrawable() : Drawable? {
   return when(this) {
        is GlideState.None -> null
        is GlideState.Loading -> drawable
        is GlideState.Success -> drawable
        is GlideState.Error -> drawable
    }
}