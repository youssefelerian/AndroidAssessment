package com.youssef.core.domain.interactor

import com.youssef.core.domain.entity.ErrorEntity
import com.youssef.core.domain.entity.Outcome

interface UseCase<R> {
    suspend fun onSuccess(success: Outcome.Success<R>)
    suspend fun onEmpty()
    suspend fun onError(error: ErrorEntity)
}