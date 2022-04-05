package com.godgod.feature.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<out T : ViewDataBinding>(
    @LayoutRes private val res: Int
) : AppCompatActivity() {

    private var _binding: T? = null
    protected val binding: T
        get() = checkNotNull(_binding) {
            "AppCompatActivity $this binding cannot be accessed before onCreate() or after onDestroy()"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, res)
        setup()
        observeViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding?.unbind()
        _binding = null
    }

    protected abstract fun setup()
    protected inline fun initBinding(block: T.() -> Unit) {
        block(binding)
        binding.executePendingBindings()
    }
    protected open fun observeViewModel() {}

    interface ParamFactory<T> {
        fun getIntent(context: Context, param : T) : Intent
        fun start(context : Context, param: T) {
            context.startActivity(getIntent(context, param))
        }
    }

    interface NoParamFactory {
        fun getIntent(context: Context) : Intent
        fun start(context: Context) {
            context.startActivity(getIntent(context))
        }
    }
}