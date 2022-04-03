package com.godgod.feature.util

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.godgod.feature.base.BaseViewHolder

internal class CommonAdapter<T> private constructor(
    private val viewHolderFactory: (parent: ViewGroup, viewType: Int) -> BaseViewHolder<T>,
    diffUtil: DiffUtil.ItemCallback<T>,
    private val viewTypeConverter: ((T) -> Int)? = null
) : ListAdapter<T, BaseViewHolder<T>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return viewHolderFactory.invoke(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypeConverter?.invoke(getItem(position)) ?: super.getItemViewType(position)
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<T>) {
        holder.onViewAttachedToWindow()
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<T>) {
        holder.onViewDetachedToWindow()
    }

    override fun onViewRecycled(holder: BaseViewHolder<T>) {
        holder.onViewRecycled()
    }

    companion object {

        inline fun <T> buildOf(
            noinline viewHolderFactory: (parent: ViewGroup, viewType: Int) -> BaseViewHolder<T>,
            crossinline areItemsTheSame: (oldItem: T, newItem: T) -> (Boolean),
            crossinline areContentsTheSame: (oldItem: T, newItem: T) -> (Boolean),
            noinline viewTypeConverter: ((T) -> Int)? = null
        ): CommonAdapter<T> {
            return CommonAdapter<T>(
                viewHolderFactory = viewHolderFactory,
                diffUtil = object : DiffUtil.ItemCallback<T>() {
                    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                        return areItemsTheSame(oldItem, newItem)
                    }

                    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                        return areContentsTheSame(oldItem, newItem)
                    }
                },
                viewTypeConverter = viewTypeConverter
            )
        }
    }
}