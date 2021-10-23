package com.godgod.domain.base

import com.godgod.shared.model.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

abstract class BaseFlowUseCase<in P, out R>(val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(params: P): Flow<DataResult<R>> {
        return execute()
            .flowOn(coroutineDispatcher)
            .map { DataResult.Success(it) }
            .catch { DataResult.Error(it) }
    }

    protected abstract fun execute() : Flow<R>
}