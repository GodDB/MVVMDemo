package com.godgod.shared.extension

inline fun <T> Result<T>.getOrDefaultBlock(block : () -> T) : T {
    if (isFailure) return block.invoke()
    return this.getOrNull()!!
}