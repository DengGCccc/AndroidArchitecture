package com.gc.architecture.module

import com.gc.architecture.module.core.IModuleContext

/**
 * Created by Deng on 2019-07-25.
 */
interface IModule {
    fun getModuleContext(): IModuleContext
}