package com.gc.architecture

import com.gc.architecture.data.IDataManager

/**
 * Created by Deng on 2019-07-22.
 */
interface IAppContext {
    fun getDataManager(): IDataManager
}