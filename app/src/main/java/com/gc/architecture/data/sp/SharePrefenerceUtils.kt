package com.gc.architecture.data.sp

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Deng on 2019-07-22.
 */
object SharePrefenerceUtils {
    const val FILE_NAME = "myapp"

    /**
     * 保存数据
     * @param context
     * @param key
     * @param object
     */
    fun put(context: Context, key: String, value: Any?) {
        val editor = getEditor(context)

        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            else -> editor.putString(key, value.toString())
        }

        editor.commit()
    }

    /**
     * 获取数据
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */

    operator fun get(context: Context, key: String, defaultValue: Any): Any? {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

        when (defaultValue) {
            is String -> return sp.getString(key, defaultValue)
            is Int -> return sp.getInt(key, defaultValue)
            is Boolean -> return sp.getBoolean(key, defaultValue)
            is Float -> return sp.getFloat(key, defaultValue)
            is Long -> return sp.getLong(key, defaultValue)
            else -> return null
        }
    }

    /**
     * remove key
     * @param context
     * @param key
     */
    fun remove(context: Context, key: String) {
        val editor = getEditor(context)
        editor.remove(key)
        editor.commit()
    }

    /**
     * 判断是否包含key
     * @param context
     * @param key
     * @return
     */
    fun contains(context: Context, key: String): Boolean {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return sp.contains(key)
    }

    /**
     * 清空数据
     * @param context
     */
    fun clear(context: Context) {
        val editor = getEditor(context)
        editor.clear()
        editor.commit()
    }

    private fun getEditor(context: Context): SharedPreferences.Editor {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return sp.edit()
    }
}