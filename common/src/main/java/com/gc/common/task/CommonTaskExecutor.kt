package com.gc.common.task

import android.os.Looper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Deng on 2019-07-22.
 */
object CommonTaskExecutor {
    private val mCompositeDisposable = CompositeDisposable()

    fun postToMainThread(runnable: Runnable?) {
        postToMainThread(runnable, 0)
    }

    fun postToMainThread(runnable: Runnable?, delayMillis: Long) {
        Observable
            .just("")
            .delay(delayMillis, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                runnable?.run()
            }
            .addTo(mCompositeDisposable)
    }

    fun isMainThread(): Boolean {
        val currentThread = Thread.currentThread()
        val mainThread = Looper.getMainLooper()?.thread

        return mainThread === currentThread
    }

    fun destroy() {
        mCompositeDisposable.dispose()
    }

    private fun Disposable.addTo(c: CompositeDisposable) {
        c.add(this)
    }
}