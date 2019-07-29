package com.gc.architecture.module.part3

import com.gc.architecture.module.core.BaseModulePresenter
import com.gc.architecture.module.core.IModuleContext
import com.gc.architecture.module.part1.Part1Presenter
import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
class Part3Presenter(moduleContext: IModuleContext) : IPart3Presenter, BaseModulePresenter(moduleContext) {
    var mPart3View: Part3View? = null

    override fun attachView(mvpView: IMvpView) {
        super.attachView(mvpView)

        mPart3View = mvpView as Part3View
    }

    override fun showView() {
        mPart3View?.showView()
    }

    override fun hideView() {
        mPart3View?.hideView()
    }

    fun btnClick() {
        hideView()
        getPresenter(Part1Presenter::class.java).showView()
    }
}