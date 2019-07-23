package com.gc.architecture.base

import com.gc.architecture.IAppContext
import com.gc.architecture.data.IDataManager
import com.gc.common.mvp.IMvpPresenter
import com.gc.common.mvp.IMvpView

/**
 * Created by Deng on 2018/7/25.
 */
open class BasePresenter<V : IMvpView>(appContext: IAppContext) : IMvpPresenter<V> {
    var mAppContext: IAppContext = appContext

    /**
     * 绑定的view
     */
    var mView: V? = null

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    override fun attachView(mvpView: V) {
        this.mView = mvpView
    }

    /**
     * 断开view，已在BaseActivity onDestroy中调用
     */
    override fun detachView() {
        this.mView = null
    }

    fun getDataManager(): IDataManager {
        return mAppContext.getDataManager()
    }
}
