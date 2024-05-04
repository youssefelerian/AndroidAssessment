package   com.youssef.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {

    private val backgroundScope = CoroutineScope(Dispatchers.IO)

    fun execute(asyncOp: suspend CoroutineScope.() -> Unit): Job {
        return backgroundScope.launch { asyncOp() }
    }

    override fun onCleared() {
        super.onCleared()
        backgroundScope.coroutineContext.cancel()
    }

}