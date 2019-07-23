package com.gc.architecture.data

import com.gc.architecture.data.bean.UserBean
import com.gc.architecture.data.listener.IUserInfoChangerListener
import com.gc.common.net.Callback

/**
 * Created by Deng on 2019-07-22.
 */
interface IDataManager {
    fun saveUid(uid: String?)
    fun getUid(): String?
    fun getUserInfo(callback: Callback<UserBean>?)
    fun addUserInfoChangedListener(listener: IUserInfoChangerListener?)
    fun removeUserInfoChangedListener(listener: IUserInfoChangerListener?)
}