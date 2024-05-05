package com.youssef.core.navigation

import android.net.Uri
import androidx.navigation.NavController

interface DeeplinkProcessor {
    fun matches(deeplink: Uri): Boolean

    fun execute(deeplink: Uri, navController: NavController)

}