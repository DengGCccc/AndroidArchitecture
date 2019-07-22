package com.gc.common.base

import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.gc.common.mvp.IMvpView
import com.gc.common.utils.CommonProgressDialog
import com.gc.common.utils.ToastUtils
import java.util.HashSet

/**
 * Created by Deng on 2018/7/25.
 */
abstract class BaseActivity : FragmentActivity(), IMvpView {

    private val presenterSet = HashSet<BasePresenter<*>>()

    private var mProgressDialog: CommonProgressDialog? = null

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
