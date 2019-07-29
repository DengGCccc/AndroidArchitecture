package com.gc.architecture.module

import com.gc.architecture.IAppContext
import com.gc.architecture.module.core.IModuleContext
import com.gc.architecture.module.core.ModuleContext

/**
 * Created by Deng on 2019-07-25.
 */
class Module(appContext: IAppContext) : IModule {
    private var mModuleContext: IModuleContext = ModuleContext(appContext)

    override fun getModuleContext(): IModuleContext {
        return mModuleContext
    }
}