package com.gc.architecture.module.core

import com.gc.architecture.IAppContext

/**
 * Created by Deng on 2019-07-25.
 */
interface IModuleContext : IAppContext {
    fun <T : BaseModulePresenter> getPresenter(clazz: Class<T>): T
}