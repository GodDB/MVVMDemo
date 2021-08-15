package com.example.mvvmdemo.extension

inline fun <T> Result<T>.getOrDefaultBlock(block : () -> T) : T {
    if (isFailure) return block.invoke()
    return this.getOrNull()!!
}