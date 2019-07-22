package com.gc.architecture

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.gc.architecture.sample.NetActivity

/**
 * Created by Deng on 2018/7/25.
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun btnClick(v: View) {
        startActivity(Intent(this, NetActivity::class.java))
    }
}
