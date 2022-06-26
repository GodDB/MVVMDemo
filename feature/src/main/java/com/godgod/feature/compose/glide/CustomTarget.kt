package com.godgod.feature.compose.glide

import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.trySendBlocking

internal class CustomTarget constructor(
    private val producerScope: ProducerScope<GlideState>
) : CustomTarget<Drawable>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {

    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
        producerScope.trySendBlocking(GlideState.Success(resource))
    }

    override fun onLoadStarted(placeholder: Drawable?) {
        super.onLoadStarted(placeholder)
        producerScope.trySendBlocking(GlideState.Loading(placeholder))
    }

    override fun onLoadFailed(errorDrawable: Drawable?) {
        super.onLoadFailed(errorDrawable)
        producerScope.trySendBlocking(GlideState.Error(errorDrawable))
        producerScope.channel.close()
    }

    override fun onLoadCleared(placeholder: Drawable?) {
        producerScope.channel.close()
    }
}