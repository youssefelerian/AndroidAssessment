package com.youssef.core.domain.interactor

import com.youssef.core.domain.entity.ErrorEntity
import com.youssef.core.domain.entity.Outcome


abstract class AsyncUseCase<I, R> : UseCase<R> {

    private lateinit var success: suspend (R) -> Unit
    private lateinit var empty: suspend () -> Unit
    private lateinit var error: suspend (ErrorEntity) -> Unit

    suspend fun execute(
        input: I,
        success: suspend (R) -> Unit = {},
        empty: suspend () -> Unit = {},
        error: suspend (ErrorEntity) -> Unit = {}
    ) {
        this.success = success
        this.empty = empty
        this.error = error
        run(input).accept(this)
    }
    protected abstract suspend fun run(input: I): Outcome<R>

    override suspend fun onSuccess(success: Outcome.Success<R>) {
        if (success.data is List<*>) {
            val list = success.data as List<*>
            if (list.isEmpty()) {
                empty()
            } else {
                success(success.data)
            }
        } else {
            success(success.data)
        }
    }

    override suspend fun onEmpty() {
        empty()
    }

    override suspend fun onError(error: ErrorEntity) {
        error(error)
    }
}