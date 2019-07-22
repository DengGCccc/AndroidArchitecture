package com.gc.common.net

import com.gc.common.utils.logger.AppLog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class NormalObserver<T> : Observer<NormalResult<T>> {

    override fun onSubscribe(d: Disposable) {}

    override fun onNext(result: NormalResult<T>) {
        if (result.code == SUCCESS_CODE) {
            val t = result.data
            AppLog.i("result: $t")
            onSuccess(t)
        } else {
            onError(result.code, result.msg)
        }
    }

    override fun onError(e: Throwable) {
        AppLog.e("error:$e")
        onError(UNKNOWN_ERROR, e.message)
        onComplete()
    }

    override fun onComplete() {
        AppLog.i("onComplete")
    }

    abstract fun onSuccess(result: T?)

    fun onError(code: Int, message: String?) {
    }

    companion object {
        const val SUCCESS_CODE = 0
        const val UNKNOWN_ERROR = 9999
    }
}
