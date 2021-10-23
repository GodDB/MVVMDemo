package com.godgod.domain.base

import com.godgod.shared.model.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseCoroutineUseCase<in P, out T>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parmas: P): DataResult<T> {
        return withContext(coroutineDispatcher) {
            try {
                DataResult.Success(execute(parmas))
            } catch (e : Exception) {
                DataResult.Error(e)
            }
        }
    }

    protected abstract suspend fun execute(params: P): T
}