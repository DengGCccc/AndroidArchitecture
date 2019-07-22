package com.gc.architecture.sample

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.gc.architecture.R
import com.gc.architecture.base.BaseActivity

class NetActivity : BaseActivity(), NetView {
    private lateinit var text: TextView
    private lateinit var presenter: NetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        text = findViewById(R.id.text)

        presenter = NetPresenter(mAppContext)
        presenter.attachView(this)
        addPresenters(presenter)
    }

    fun btnClick(v: View?) {
        presenter.getUserInfo()
    }

    override fun showData(data: String?) {
        text.text = data
    }
}