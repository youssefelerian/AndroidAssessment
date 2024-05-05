package com.youssef.list.navigation

import android.net.Uri
import androidx.navigation.NavController
import com.youssef.core.navigation.DeeplinkProcessor
import com.youssef.core.navigation.model.ListNavigation
import javax.inject.Inject


class UniversityListDeeplinkProcessor @Inject constructor() :
    DeeplinkProcessor {

    override fun matches(deeplink: Uri): Boolean {
        return deeplink.toString().contains(ListNavigation().navigationName)
    }

    override fun execute(deeplink: Uri, navController: NavController) {
    }
}