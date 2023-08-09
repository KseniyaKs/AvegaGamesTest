package com.example.avegagamestest.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.text.DateFormat
import java.util.Date

fun <T> Fragment.observe(liveData: LiveData<T?>, observer: ((T) -> Unit)) {
    liveData.observe(viewLifecycleOwner, Observer {
        if (it != null) {
            observer.invoke(it)
        } else {
            //TODO log this
        }
    })
}

fun String.titleCaseFirstChar() = replaceFirstChar(Char::titlecase)

fun Long.convertLongToDate(): String {
    return DateFormat.getInstance().format(Date(this)).toString()
}

