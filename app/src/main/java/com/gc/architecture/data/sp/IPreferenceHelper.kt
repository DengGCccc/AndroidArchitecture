package com.gc.architecture.data.sp

/**
 * Created by Deng on 2019-07-22.
 */
interface IPreferenceHelper {
    fun saveUid(uid: String?)
    fun getUid(): String?
}