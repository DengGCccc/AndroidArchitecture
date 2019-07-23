package com.gc.architecture.data

import com.gc.architecture.data.api.ApiHelper
import com.gc.architecture.data.api.IApiHelper
import com.gc.architecture.data.sp.IPreferenceHelper
import com.gc.architecture.data.sp.PreferenceHelper
import com.gc.architecture.data.bean.UserBean
import com.gc.architecture.data.db.DbHelper
import com.gc.architecture.data.db.IDbHelper
import com.gc.architecture.data.listener.IUserInfoChangerListener
import com.gc.common.net.Callback
import com.gc.common.utils.RuntimeContext
import java.lang.ref.WeakReference

/**
 * Created by Deng on 2019-07-22.
 */
class DataManager : IDataManager {
    private val mPreferenceHelper: IPreferenceHelper = PreferenceHelper(RuntimeContext.sApplicationContext)
    private val mDbHelper: IDbHelper = DbHelper()
    private val mApiHelper: IApiHelper = ApiHelper()

    private val mUserChangeListeners = ArrayList<WeakReference<IUserInfoChangerListener>>()

    override fun saveUid(uid: String?) {
        mPreferenceHelper.saveUid(uid)
    }

    override fun getUid(): String? {
        return mPreferenceHelper.getUid()
    }

    override fun getUserInfo(callback: Callback<UserBean>?) {
        mApiHelper.getUserInfo(object : Callback<UserBean> {
            override fun onSuccess(data: UserBean?) {
                callback?.onSuccess(data)

                for (ref in mUserChangeListeners) {
                    ref.get()?.apply {
                        userChanged(data)
                    }
                }
            }

            override fun onComplete() {
                super.onComplete()
                callback?.onComplete()
            }

            override fun onFail(code: Int, msg: String?) {
                super.onFail(code, msg)
                callback?.onFail(code, msg)
            }
        })
    }

    override fun addUserInfoChangedListener(listener: IUserInfoChangerListener?) {
        if (null == listener) {
            return
        }

        for (ref in mUserChangeListeners) {
            val l = ref.get()
            if (l == listener) {
                return
            }
        }

        mUserChangeListeners.add(WeakReference(listener))
    }

    override fun removeUserInfoChangedListener(listener: IUserInfoChangerListener?) {
        if (null == listener || mUserChangeListeners.isEmpty()) {
            return
        }

        for (ref in mUserChangeListeners) {
            val l = ref.get()
            if (l == listener) {
                mUserChangeListeners.remove(ref)
                break
            }
        }
    }
}