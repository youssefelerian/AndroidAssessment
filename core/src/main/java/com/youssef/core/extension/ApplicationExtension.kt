package com.youssef.core.extension

import android.content.Context
import androidx.core.content.ContextCompat

/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

fun Context.getResColor(res: Int) = ContextCompat.getColor(this, res)

fun Context.getResDrawable(res: Int) = ContextCompat.getDrawable(this, res)
