package com.godgod.feature.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

internal abstract class BaseViewHolder<in T>(
    viewDataBinding: ViewDataBinding
) : RecyclerView.ViewHolder(viewDataBinding.root) {

    abstract fun bind(data : T)

    open fun onViewAttachedToWindow() {
        //자식 클래스에서 구체화 한다.
    }

    open fun onViewDetachedToWindow() {
        //자식 클래스에서 구체화 한다.
    }

    open fun onViewRecycled() {
        //자식 클래스에서 구체화 한다.
    }
}