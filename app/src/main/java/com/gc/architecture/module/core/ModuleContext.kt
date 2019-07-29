package com.gc.architecture.module.core

import com.gc.architecture.IAppContext
import com.gc.architecture.data.IDataManager

/**
 * Created by Deng on 2019-07-25.
 */
class ModuleContext(appContext: IAppContext) : IModuleContext {
    private val mAppContext: IAppContext = appContext

    private val mPresenters = HashMap<String, BaseModulePresenter>()

    override fun <T : BaseModulePresenter> getPresenter(clazz: Class<T>): T {
        val canonicalName =
            clazz.canonicalName ?: throw IllegalArgumentException("Local and anonymous classes can not be Presenter")

        var presenter = mPresenters.get(canonicalName)
        if (clazz.isInstance(presenter)) {
            return presenter as T
        }

        val constructor = clazz.getConstructor(IModuleContext::class.java)
        presenter = constructor.newInstance(this) as T
        mPresenters.put(canonicalName, presenter)
        return presenter
    }

    override fun getDataManager(): IDataManager {
        return mAppContext.getDataManager()
    }
}