package com.youssef.details.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.youssef.core.navigation.DeeplinkProcessor
import com.youssef.core.navigation.model.DetailsNavigation
import javax.inject.Inject


class UniversityDetailsDeeplinkProcessor @Inject constructor() :
    DeeplinkProcessor {
    override fun matches(deeplink: Uri): Boolean {
        return deeplink.toString().contains(DetailsNavigation().navigationName)
    }

    override fun execute(deeplink: Uri, navController: NavController) {
        val request = NavDeepLinkRequest.Builder
            .fromUri(deeplink)
            .build()
        navController.navigate(request)
    }
}