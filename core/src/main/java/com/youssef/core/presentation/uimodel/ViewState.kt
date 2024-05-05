package com.youssef.core.presentation.uimodel

import androidx.lifecycle.MutableLiveData

sealed class ViewState<T> {

    class LoadingState<T> : ViewState<T>()
    class SuccessState<T>(val data: T) : ViewState<T>()
    class ErrorState<T>(val title: String, val message: String) : ViewState<T>()

    class EmptyState<T> : ViewState<T>()
    companion object {
        fun <T> loading() = LoadingState<T>()

        fun <T> success(data: T) = SuccessState(data)

        fun <T> error(title: String, message: String) = ErrorState<T>(title, message)

        fun <T> empty() = EmptyState<T>()
    }
}

typealias MutableStateLiveData<T> = MutableLiveData<ViewState<T>>