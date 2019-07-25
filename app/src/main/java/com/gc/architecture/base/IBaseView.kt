package com.gc.architecture.base

import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2019-07-24.
 */
interface IBaseView : IMvpView {
    /**
     * 显示正在加载进度条
     */
    fun showLoading()

    /**
     * 关闭正在加载进度条
     */
    fun hideLoading()

    /**
     * Toast提示
     *
     * @param msg
     */
    fun showToast(msg: String)
}