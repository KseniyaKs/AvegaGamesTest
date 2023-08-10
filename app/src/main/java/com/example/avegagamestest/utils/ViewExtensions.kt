package com.example.avegagamestest.utils

import android.os.Build
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import java.util.Date

fun <T> Fragment.observe(liveData: LiveData<T?>, observer: ((T) -> Unit)) {
    liveData.observe(viewLifecycleOwner) {
        if (it != null) {
            observer.invoke(it)
        } else {
            Log.e("error", "liveData.value is null")
        }
    }
}

fun String.titleCaseFirstChar() = replaceFirstChar(Char::titlecase)

fun Long.convertLongToDate(): String {
    return Date(this * 1000L).toString()
}

fun String.convertHtmlText(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(this).toString()
    }
}

