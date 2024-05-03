package com.youssef.core.extension

import android.app.Dialog
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.youssef.core.R


/**
 * Created by Youssef Ebrahim Elerian on 3/5/24.
 * youssef.elerian@gmail.com
 */

fun AlertDialog.Builder.createConfirmAlert(
    message: String,
    positiveText: String,
    positiveListener: View.OnClickListener? = null
): Dialog {
    return createCustomAlert(
        message,
        positiveText,
        context.getString(R.string.dialog_no),
        positiveListener,
        null,
        true
    )
}

fun AlertDialog.Builder.createErrorAlert(
    message: String,
    positiveListener: View.OnClickListener? = null
): Dialog {
    return createCustomAlert(
        message,
        context.getString(R.string.dialog_ok),
        null,
        positiveListener,
        null,
        true
    )
}

fun AlertDialog.Builder.createCustomAlert(
    message: String? = null, positiveText: String,
    negativeText: String? = null, positiveListener: View.OnClickListener? = null,
    negativeListener: View.OnClickListener? = null,
    cancelable: Boolean = true
): Dialog {
    var dialog = Dialog(context)
    message?.let { setMessage(message) }
    setPositiveButton(positiveText) { _, _ ->
        dialog.dismiss()
        positiveListener?.onClick(View(context))
    }
    negativeText?.let {
        setNegativeButton(it) { _, _ ->
            dialog.dismiss()
            negativeListener?.onClick(View(context))
        }
    }
    setCancelable(cancelable)
    dialog = create()

    dialog.show()

    return dialog

}
