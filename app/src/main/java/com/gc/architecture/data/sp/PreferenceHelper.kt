package com.gc.architecture.data.sp

import android.content.Context

/**
 * Created by Deng on 2019-07-22.
 */
class PreferenceHelper(context: Context) : IPreferenceHelper {
    private var mContext: Context = context

    override fun saveUid(uid: String?) {
        SharePrefenerceUtils.put(mContext, "uid", uid)
    }

    override fun getUid(): String? {
        return SharePrefenerceUtils.get(mContext, "uid", "") as String?
    }
}