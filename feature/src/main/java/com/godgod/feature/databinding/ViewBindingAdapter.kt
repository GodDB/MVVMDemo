package com.godgod.feature.databinding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun View.visible(visible : Boolean) {
    if(visible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

@BindingAdapter("gone")
fun View.gone(gone : Boolean) {
    if(gone) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
    }
}
