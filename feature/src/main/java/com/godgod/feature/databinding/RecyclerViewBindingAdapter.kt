package com.godgod.feature.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("submitList")
fun <T : Any>RecyclerView.submitList(list : List<T>?) {
    (this.adapter as? ListAdapter<T, *>)?.submitList(list)
}
