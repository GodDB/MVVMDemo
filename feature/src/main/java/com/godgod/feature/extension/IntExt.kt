package com.godgod.feature.extension

import android.content.res.Resources.getSystem
import android.util.TypedValue

internal object IntExt {

    fun Int.dp(): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), getSystem().displayMetrics).toInt()
    }
}