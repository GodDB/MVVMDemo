package com.godgod.domain.base

import com.godgod.shared.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseCoroutineUseCase<in P, out T>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parmas: P): Result<T> {
        return try {
            withContext(coroutineDispatcher) {
                Result.Success(execute(parmas))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    protected abstract suspend fun execute(params: P): T
}