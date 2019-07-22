package com.gc.architecture

import android.app.Application
import com.gc.architecture.data.DataManager
import com.gc.architecture.data.IDataManager
import com.gc.common.utils.RuntimeContext
import com.gc.common.utils.logger.AppLog

/**
 * Created by Deng on 2018/7/26.
 */
class MyApplication : Application() {
    lateinit var mAppContext: IAppContext

    override fun onCreate() {
        super.onCreate()
        RuntimeContext.sApplicationContext = this
        RuntimeContext.sIsDebuggable = BuildConfig.DEBUG

        mAppContext = AppContext()

        AppLog.init()
    }
}
