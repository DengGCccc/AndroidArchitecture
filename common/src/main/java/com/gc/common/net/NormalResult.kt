package com.gc.common.net

open class NormalResult<T> {
    var code: Int = 0
    var msg: String? = null
    var data: T? = null
}
