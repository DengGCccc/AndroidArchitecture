package com.gc.architecture.data

import com.gc.architecture.data.api.ApiHelper
import com.gc.architecture.data.api.IApiHelper
import com.gc.architecture.data.sp.IPreferenceHelper
import com.gc.architecture.data.sp.PreferenceHelper
import com.gc.architecture.data.bean.UserBean
import com.gc.architecture.data.db.DbHelper
import com.gc.architecture.data.db.IDbHelper
import com.gc.common.net.Callback
import com.gc.common.utils.RuntimeContext

/**
 * Created by Deng on 2019-07-22.
 */
class DataManager : IDataManager {
    private val mPreferenceHelper: IPreferenceHelper = PreferenceHelper(RuntimeContext.sApplicationContext)
    private val mDbHelper: IDbHelper = DbHelper()
    private val mApiHelper: IApiHelper = ApiHelper()

    override fun saveUid(uid: String?) {
        mPreferenceHelper.saveUid(uid)
    }

    override fun getUid(): String? {
        return mPreferenceHelper.getUid()
    }

    override fun getUserInfo(callback: Callback<UserBean>?) {
        mApiHelper.getUserInfo(callback)
    }
}