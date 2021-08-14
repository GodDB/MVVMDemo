package com.godgod.data.base

interface BaseRemoteMapper<in I, out O> {

    fun fromRemote(model : I) : O
}