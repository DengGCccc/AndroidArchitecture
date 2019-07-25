package com.gc.architecture.module.core

import com.gc.architecture.IAppContext
import com.gc.architecture.base.BasePresenter
import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
open class BaseModulePresenter(appContext: IAppContext) : BasePresenter<IMvpView>(appContext) {
}