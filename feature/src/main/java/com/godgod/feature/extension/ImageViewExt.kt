package com.godgod.feature.extension

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.godgod.feature.base.GlideApp

object ImageViewExt {

    inline fun ImageView.setImageUrl(
        imageUrl: String,
        crossinline onComplete: () -> Unit = {}
    ) {
        GlideApp.with(this)
            .load(imageUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    onComplete.invoke()
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    onComplete.invoke()
                    return false
                }
            })
            .into(this)
    }
}