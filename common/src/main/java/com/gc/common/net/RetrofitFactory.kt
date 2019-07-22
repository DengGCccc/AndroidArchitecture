package com.gc.common.net

import com.gc.common.utils.RuntimeContext
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory private constructor() {

    val retrofit: Retrofit

    private object Holder {
        val INSTANCE = RetrofitFactory()
    }

    init {
        val loggingInterceptor = HttpLoggingInterceptor()

        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        if (RuntimeContext.sIsDebuggable) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { c ->
                val builder = c.request().newBuilder()
//                builder.header("token", "abc")
                c.proceed(builder.build())
            }.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BaseApi.BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }

    companion object {
        const val TIME_OUT = 10

        val instance = Holder.INSTANCE
    }
}
