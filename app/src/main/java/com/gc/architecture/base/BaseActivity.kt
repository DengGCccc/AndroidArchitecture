package com.gc.architecture.base

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.gc.architecture.IAppContext
import com.gc.architecture.MyApplication
import com.gc.common.mvp.IMvpView
import com.gc.common.utils.CommonProgressDialog
import com.gc.common.utils.ToastUtils
import java.util.HashSet

/**
 * Created by Deng on 2018/7/25.
 */
abstract class BaseActivity : FragmentActivity(), IBaseView {
    lateinit var mAppContext: IAppContext

    private val presenterSet = HashSet<BasePresenter<*>>()

    private var mProgressDialog: CommonProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = application as MyApplication
        mAppContext = app.mAppContext
    }

    override fun showLoading() {
        if (null == mProgressDialog) {
            mProgressDialog = CommonProgressDialog(this)
            mProgressDialog!!.setCancelable(true)
        }

        if (!mProgressDialog!!.isShowing) {
            mProgressDialog!!.show()
        }
    }

    override fun hideLoading() {
        if (mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
        }
    }

    override fun showToast(msg: String) {
        ToastUtils.showToast(this, msg)
    }

    protected fun addPresenters(presenter: BasePresenter<*>) {
        presenterSet.add(presenter)
    }

    override fun onDestroy() {
        super.onDestroy()

        for (presenter in presenterSet) {
            presenter.detachView()
        }
    }
}
