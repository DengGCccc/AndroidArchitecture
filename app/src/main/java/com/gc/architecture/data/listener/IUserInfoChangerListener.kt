package com.gc.architecture.data.listener

import com.gc.architecture.data.bean.UserBean

/**
 * Created by Deng on 2019-07-23.
 */
interface IUserInfoChangerListener {
    fun userChanged(info: UserBean?)
}