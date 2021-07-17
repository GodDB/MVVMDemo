package com.example.mvvmdemo.base

interface BaseLocalMapper<M, E> {

    fun toEntity(model: M): E

    fun toModel(entity: E): M
}