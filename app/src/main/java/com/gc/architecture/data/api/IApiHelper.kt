package com.gc.architecture.data.api

import com.gc.architecture.data.bean.UserBean
import com.gc.common.net.Callback

/**
 * Created by Deng on 2019-07-22.
 */
interface IApiHelper {
    fun getUserInfo(callback: Callback<UserBean>?)
}