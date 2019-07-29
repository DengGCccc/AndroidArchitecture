package com.gc.architecture.module.core

import com.gc.architecture.base.BasePresenter
import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
open class BaseModulePresenter(moduleContext: IModuleContext) : BasePresenter<IMvpView>(moduleContext) {
    var mModuleContext: IModuleContext = moduleContext

    fun <T : BaseModulePresenter> getPresenter(clazz: Class<T>): T {
        if (null == mModuleContext) {
            throw IllegalArgumentException("context should not be null")
        }

        return mModuleContext.getPresenter(clazz)
    }
}