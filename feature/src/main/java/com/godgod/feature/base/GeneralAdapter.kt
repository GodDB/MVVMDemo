package com.godgod.feature.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


class GeneralAdapter<DATA>(
    diffUtil: DiffUtil.ItemCallback<DATA>,
    private val viewholderFactory: (viewType : Int, parent : ViewGroup) -> GeneralViewHolder<DATA>,
    private val viewTypeFactory : ((DATA) -> Int)? = null
) : ListAdapter<DATA, GeneralViewHolder<DATA>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder<DATA> {
        return viewholderFactory.invoke(viewType, parent)
    }

    override fun onBindViewHolder(holder: GeneralViewHolder<DATA>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypeFactory?.invoke(getItem(position)) ?: super.getItemViewType(position)
    }

    override fun onViewAttachedToWindow(holder: GeneralViewHolder<DATA>) {
        super.onViewAttachedToWindow(holder)
        holder.onViewAttachedToWindow()
    }

    override fun onViewDetachedFromWindow(holder: GeneralViewHolder<DATA>) {
        super.onViewDetachedFromWindow(holder)
        holder.onViewDetachedToWindow()
    }

    override fun onViewRecycled(holder: GeneralViewHolder<DATA>) {
        super.onViewRecycled(holder)
        holder.onViewRecycled()
    }
}
