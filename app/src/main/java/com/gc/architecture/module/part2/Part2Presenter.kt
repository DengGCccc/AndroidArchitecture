package com.gc.architecture.module.part2

import com.gc.architecture.module.core.BaseModulePresenter
import com.gc.architecture.module.core.IModuleContext
import com.gc.architecture.module.part3.Part3Presenter
import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
class Part2Presenter(moduleContext: IModuleContext) : IPart2Presenter, BaseModulePresenter(moduleContext) {
    var mPart2View: Part2View? = null

    override fun attachView(mvpView: IMvpView) {
        super.attachView(mvpView)

        mPart2View = mvpView as Part2View
    }

    override fun showView() {
        mPart2View?.showView()
    }

    override fun hideView() {
        mPart2View?.hideView()
    }

    fun btnClick() {
        hideView()
        getPresenter(Part3Presenter::class.java).showView()
    }
}