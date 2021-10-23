package com.godgod.feature.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.godgod.feature.BR


open class GeneralViewHolder<DATA>(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    open fun bind(data: DATA) {
        binding.apply {
            setVariable(BR.data, data)
        }.run {
            executePendingBindings()
        }
    }

    open fun onViewAttachedToWindow() {
        //자식 클래스에서 구체화 한다.
    }

    open fun onViewDetachedToWindow() {
        //자식 클래스에서 구체화 한다.
    }

    open fun onViewRecycled() {
        //자식 클래스에서 구체화한다.
    }
}