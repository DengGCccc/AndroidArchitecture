package com.gc.architecture.sample

import com.gc.architecture.IAppContext
import com.gc.architecture.base.BasePresenter
import com.gc.architecture.data.bean.UserBean
import com.gc.common.net.Callback

/**
 * Created by Deng on 2018/7/25.
 */
class NetPresenter(appContext: IAppContext) : BasePresenter<NetView>(appContext) {

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
}