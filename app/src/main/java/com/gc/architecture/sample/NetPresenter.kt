package com.gc.architecture.sample

import com.gc.architecture.IAppContext
import com.gc.architecture.base.BasePresenter
import com.gc.architecture.data.bean.UserBean
import com.gc.architecture.data.listener.IUserInfoChangerListener
import com.gc.common.net.Callback
import com.gc.common.utils.logger.AppLog

/**
 * Created by Deng on 2018/7/25.
 */
class NetPresenter(appContext: IAppContext) : BasePresenter<NetView>(appContext), IUserInfoChangerListener {

    init {
        appContext.getDataManager().addUserInfoChangedListener(this)
    }

    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    fun getUserInfo() {
        view?.showLoading()

        getDataManager().getUserInfo(object : Callback<UserBean> {
            override fun onSuccess(data: UserBean?) {
                view?.showData(data?.name + "====" + data?.age)
                mAppContext.getDataManager().saveUid(data?.userid)
            }

            override fun onComplete() {
                super.onComplete()
                view?.hideLoading()
            }
        })
    }

    override fun userChanged(info: UserBean?) {
        AppLog.i(TAG, "userChanged ${info?.userid}")
    }

    companion object {
        const val TAG = "NetPresenter"
    }
}