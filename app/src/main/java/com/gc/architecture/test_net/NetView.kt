package com.gc.architecture.test_net

import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2018/7/25.
 */
interface NetView : IMvpView {
    fun showData(data: String?)
}
