package com.godgod.data.base

interface BaseLocalMapper<M, E> {

    fun toEntity(model: M): E

    fun toModel(entity: E): M
}