package com.gc.architecture.module.core

import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
interface IModuleView : IMvpView {
    fun setPresenter(presenter: BaseModulePresenter)
}