package com.gc.architecture

import android.app.Application
import com.gc.common.utils.RuntimeContext
import com.gc.common.utils.logger.AppLogger

/**
 * Created by Deng on 2018/7/26.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RuntimeContext.sApplicationContext = this

        AppLogger.init()
    }
}