package com.godgod.feature.databinding

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.godgod.feature.base.GlideApp

@BindingAdapter("glide_url")
fun ImageView.bindGlide(imageUrl: String?) {
    GlideApp.with(this)
        .load(imageUrl)
        .into(this)
}


