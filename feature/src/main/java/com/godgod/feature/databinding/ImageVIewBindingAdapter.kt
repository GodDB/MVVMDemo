package com.godgod.feature.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.godgod.feature.base.GlideApp

@BindingAdapter("glide_url")
fun ImageView.bindGlide(imageUrl: String?) {
    GlideApp.with(this)
        .load(imageUrl)
        .into(this)
}

