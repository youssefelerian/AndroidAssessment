package com.youssef.core.navigation

import android.net.Uri
import androidx.navigation.NavController

interface DeeplinkHandler {
    fun process(deeplink: Uri, navController: NavController): Boolean
}