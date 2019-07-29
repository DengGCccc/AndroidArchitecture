package com.gc.architecture.module.part1

import com.gc.architecture.module.core.BaseModulePresenter
import com.gc.architecture.module.core.IModuleContext
import com.gc.architecture.module.part2.Part2Presenter
import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
class Part1Presenter(moduleContext: IModuleContext) : IPart1Presenter, BaseModulePresenter(moduleContext) {
    var mPart1View: Part1View? = null

    override fun attachView(mvpView: IMvpView) {
        super.attachView(mvpView)

        mPart1View = mvpView as Part1View
    }

    override fun showView() {
        mPart1View?.showView()
    }

    override fun hideView() {
        mPart1View?.hideView()
    }

    fun btnClick() {
        hideView()
        getPresenter(Part2Presenter::class.java).showView()
    }
}