package com.youssef.core.navigation.model

import android.content.Context
import android.net.Uri
import com.youssef.core.R

interface DeeplinkModel {
    val navigationName: String
    fun build(context: Context, param: String): Uri
}

class DetailsNavigation : DeeplinkModel {
    override val navigationName: String = "details"
    val paramName = "name"
    override fun build(context: Context, param: String): Uri {
        return Uri.parse(
            context.getString(R.string.details_module).replace("{$paramName}", param)
        )
    }
}

class ListNavigation : DeeplinkModel {
    override val navigationName: String = "list"
    val paramName = "refresh"
    override fun build(context: Context, param: String): Uri {
        return Uri.parse(context.getString(R.string.list_module))
    }
}
