package com.soluone.com.maishameds.data

import timber.log.Timber
import kotlin.properties.Delegates

class Variables {
    companion object {
        var isNetworkConnected: Boolean by Delegates.observable(true) { property, oldValue, newValue ->
            Timber.e("Value $property updated from $oldValue, to $newValue")
        }
    }
}