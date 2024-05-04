package com.youssef.core.data.network.data.source

import com.youssef.core.data.network.NetworkMonitor
import com.youssef.core.data.network.data.model.NO_NETWORK
import com.youssef.core.data.network.data.model.OTHER_ERROR_NETWORK
import com.youssef.core.domain.entity.ErrorEntity
import com.youssef.core.domain.entity.Outcome
import retrofit2.Response

class NetworkDataSource<SERVICE>(
    private val service: SERVICE,
    private val networkMonitor: NetworkMonitor
) {

    suspend fun <R, T> performRequest(
        request: suspend SERVICE.() -> Response<R>,
        onSuccess: suspend (R) -> Outcome<T>,
        onEmpty: suspend () -> Outcome<T> = { Outcome.empty() },
        onError: suspend (ErrorEntity) -> Outcome<T> = { Outcome.error(it) }
    ): Outcome<T> {
        return if (networkMonitor.hasConnectivity()) {
            try {
                val response = service.request()
                val errorBody = response.errorBody()?.string() ?: ""
                if (response.isSuccessful) {
                    val body = response.body()
                    return if (body != null && body != Unit) {
                        onSuccess(body)
                    } else {
                        onEmpty()
                    }
                } else {
                    onError(ErrorEntity(Exception(errorBody), response.code()))
                }
            } catch (e: Exception) {
                onError(ErrorEntity(e, OTHER_ERROR_NETWORK))
            }
        } else {
            onError(ErrorEntity(Exception("No Connectivity"), NO_NETWORK))
        }
    }

}