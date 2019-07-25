package com.gc.architecture.module.part2

import android.content.Context
import android.widget.LinearLayout
import com.gc.architecture.module.core.BaseModulePresenter
import com.gc.architecture.module.core.IModuleView
import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
class Part2View(context: Context) : LinearLayout(context), IModuleView {
    private var mPresenter: Part2Presenter? = null

    override fun setPresenter(presenter: BaseModulePresenter) {
        mPresenter = presenter as Part2Presenter
        mPresenter?.attachView(this)
    }
}