package com.gc.architecture.data.api

import com.gc.architecture.data.bean.UserBean
import com.gc.common.net.Callback
import com.gc.common.net.NormalObserver
import java.util.HashMap

/**
 * Created by Deng on 2019-07-22.
 */
class ApiHelper : IApiHelper {
    override fun getUserInfo(callback: Callback<UserBean>?) {
        val map = HashMap<String, Any>()
        map.put("uid", "AP170102105451")

        TestApi.instance.getUser(map, object : NormalObserver<UserBean>() {
            override fun onSuccess(result: UserBean?) {
                callback?.onSuccess(result)
            }

            override fun onComplete() {
                super.onComplete()
                callback?.onComplete()
            }
        })
    }
}