package com.youssef.assessment.navigation

import android.net.Uri
import androidx.navigation.NavController
import com.youssef.core.navigation.DeeplinkHandler
import com.youssef.core.navigation.DeeplinkProcessor
import javax.inject.Inject


class RootDeeplinkHandler @Inject constructor(
    private val processors: Set<@JvmSuppressWildcards DeeplinkProcessor>
) : DeeplinkHandler {
    override fun process(deeplink: Uri, navController: NavController): Boolean {
        processors.forEach {
            if (it.matches(deeplink)) {
                it.execute(deeplink, navController)
                return true
            }
        }
        return false
    }
}