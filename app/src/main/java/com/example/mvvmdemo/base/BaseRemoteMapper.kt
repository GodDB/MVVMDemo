package com.example.mvvmdemo.base

interface BaseRemoteMapper<in I, out O> {

    fun fromRemote(model : I) : O
}