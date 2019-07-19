package com.gc.common.utils.logger

import android.util.Log

import com.gc.common.BuildConfig
import com.gc.common.R
import com.gc.common.utils.ResourceUtils

object AppLogger {

    fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }

//        Timber.tag(ResourceUtils.getString(R.string.app_name))
    }

    private class ReleaseTree : Timber.DebugTree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }

            super.log(priority, tag, message, t)
        }
    }

    fun d(s: String, vararg objects: Any) {
        Timber.d(s, *objects)
    }

    fun i(s: String, vararg objects: Any) {
        Timber.i(s, *objects)
    }

    fun w(s: String, vararg objects: Any) {
        Timber.w(s, *objects)
    }

    fun e(s: String, vararg objects: Any) {
        Timber.e(s, *objects)
    }
}
