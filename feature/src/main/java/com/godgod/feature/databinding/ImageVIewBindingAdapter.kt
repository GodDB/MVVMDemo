package com.godgod.feature.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("glide_url")
fun ImageView.bindGlide(imageUrl: String?) {
    Glide.with(context)
        .load(imageUrl)
        .into(this)
}