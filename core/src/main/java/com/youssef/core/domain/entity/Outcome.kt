package com.youssef.core.domain.entity

import com.youssef.core.domain.interactor.UseCase
import kotlinx.coroutines.isActive
import kotlin.coroutines.coroutineContext


sealed class Outcome<T> {
    abstract fun isSuccess(): Boolean
    open fun errorMessage(): ErrorEntity? = null
    abstract suspend fun accept(useCase: UseCase<T>)


    class Success<T>(val data: T) : Outcome<T>() {
        override fun isSuccess() = true
        override suspend fun accept(useCase: UseCase<T>) {
            useCase.onSuccess(this)
        }
    }

    class Error<T>(private val error: ErrorEntity) : Outcome<T>() {
        override fun isSuccess() = false
        override suspend fun accept(useCase: UseCase<T>) {
            useCase.onError(error)
        }

        override fun errorMessage() = error
    }

    class Empty<T> : Outcome<T>() {
        override fun isSuccess() = true
        override suspend fun accept(useCase: UseCase<T>) {
            useCase.onEmpty()
        }
    }

    companion object {
        fun <T> success(data: T) = Success(data)
        fun <T> error(error: ErrorEntity) = Error<T>(error)
        fun <T> empty() = Empty<T>()
    }
}

suspend fun <T> Outcome<T>.doOnSuccess(onSuccess: suspend (T) -> Unit): Outcome<T> {
    if (this is Outcome.Success<T>) {
        if (coroutineContext.isActive) {
            onSuccess(this.data)
        }
    }

    return this
}

suspend fun <T> Outcome<T>.doOnEmpty(onEmpty: suspend () -> Unit): Outcome<T> {
    if (this is Outcome.Empty) {
        if (coroutineContext.isActive) {
            onEmpty()
        }
    }

    return this
}

fun <T> Outcome<T>.doOnError(onError: () -> Unit): Outcome<T> {
    if (!this.isSuccess()) {
        onError()
    }

    return this
}

suspend fun <T> Outcome<T>.onErrorResume(onError: suspend (Outcome.Error<T>) -> Outcome<T>): Outcome<T> {
    return if (!this.isSuccess()) {
        onError(this as Outcome.Error<T>)
    } else {
        this
    }
}
