package com.gc.common.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.support.annotation.StringRes
import android.text.TextUtils
import android.widget.Toast
import com.gc.common.task.CommonTaskExecutor
import com.gc.common.utils.logger.AppLog

object ToastUtils {

    private const val TAG = "ToastUtils"

    @Volatile
    private var sCustomToast: ICustomToast? = null

    fun showToast(context: Context, message: String) {
        showToast(context, message, Toast.LENGTH_SHORT, -1)
    }

    fun showToast(context: Context, message: String, length: Int) {
        showToast(context, message, length, -1)
    }

    fun showToast(context: Context, @StringRes stringId: Int) {
        showToast(context, ResourceUtils.getString(stringId), Toast.LENGTH_SHORT, -1)
    }

    fun showToast(context: Context, @StringRes stringId: Int, length: Int) {
        showToast(context, ResourceUtils.getString(stringId), length, -1)
    }

    fun showToast(context: Context?, message: CharSequence, length: Int, gravity: Int = -1) {
        if (context == null || TextUtils.isEmpty(message)) {
            return
        }

        val command = Runnable {
            AppLog.i(TAG, "$message")
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1 || TextUtils.equals(Build.BRAND, "Meizu")) {
                if (sCustomToast != null) {
                    if (sCustomToast!!.canHack()) {
                        sCustomToast!!.showToast(message, length)
                    } else {
                        CommonTaskExecutor.postToMainThread(Runnable {
                            if (sCustomToast != null) {
                                sCustomToast!!.showToast(message, length)
                            }
                        }, 1000)
                    }
                } else {
                    val toast = Toast.makeText(context, message, length)
                    if (gravity > 0) {
                        toast.setGravity(gravity, 0, 0)
                    }
                    toast.show()
                }
            } else {
                val toast = Toast.makeText(context, message, length)
                if (gravity > 0) {
                    toast.setGravity(gravity, 0, 0)
                }
                toast.show()
            }
        }


        if (!CommonTaskExecutor.isMainThread()) {
            CommonTaskExecutor.postToMainThread(command)
        } else {
            command.run()
        }
    }

    fun showToast(context: Activity?, @StringRes message: Int, length: Int) {
        if (context == null) {
            return
        }

        val command = Runnable {
            AppLog.i(TAG, "$message")
            if (!needToHack()) {
                val toast = Toast.makeText(context, message, length)
                toast.show()
            } else {
                if (sCustomToast != null) {
                    sCustomToast!!.showToast(ResourceUtils.getString(message), length)
                } else {
                    val toast = Toast.makeText(context, message, length)
                    toast.show()
                }
            }
        }

        if (!CommonTaskExecutor.isMainThread()) {
            CommonTaskExecutor.postToMainThread(command)
        } else {
            command.run()
        }
    }

    private fun needToHack(): Boolean {
        val result = Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1 || TextUtils.equals(Build.BRAND, "Meizu")
        return if (sCustomToast != null) result && sCustomToast!!.canHack() else result
    }

    fun setCustomToast(customToast: ICustomToast) {
        sCustomToast = customToast
    }

    interface ICustomToast {
        fun showToast(toast: CharSequence, length: Int)

        fun canHack(): Boolean
    }
}
