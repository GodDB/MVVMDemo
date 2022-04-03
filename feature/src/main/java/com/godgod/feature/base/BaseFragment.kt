package com.godgod.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<out T : ViewDataBinding>(
    @LayoutRes private val res: Int
) : Fragment() {

    private var _binding: T? = null
    protected val binding: T
        get() = checkNotNull(_binding) {
            "Fragment $this binding cannot be accessed before onCreateView() or after onDestroyView()"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, res, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        observeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding?.unbind()
        _binding = null
    }

    protected inline fun initBinding(initBlock: T.() -> Unit) = initBlock(binding)
    protected abstract fun setup()
    protected open fun observeViewModel() { }

    interface ParamFactory<T> {
        fun newInstance(param : T) : BaseFragment<*>
    }

    interface NoParamFactory {
        fun newInstance() : BaseFragment<*>
    }
}