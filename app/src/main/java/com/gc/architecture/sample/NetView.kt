package com.gc.architecture.sample

import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2018/7/25.
 */
interface NetView : IMvpView {
    fun showData(data: String?)
}
