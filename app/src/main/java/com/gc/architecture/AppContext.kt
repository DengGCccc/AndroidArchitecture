package com.gc.architecture

import com.gc.architecture.data.DataManager
import com.gc.architecture.data.IDataManager

/**
 * Created by Deng on 2019-07-22.
 */
class AppContext : IAppContext {
    private var mDataManager: IDataManager = DataManager()

    override fun getDataManager(): IDataManager {
        return mDataManager
    }
}
