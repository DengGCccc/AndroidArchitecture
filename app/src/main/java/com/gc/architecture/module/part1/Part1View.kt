package com.gc.architecture.module.part1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.gc.architecture.R
import com.gc.architecture.module.core.BaseModulePresenter
import com.gc.architecture.module.core.IModuleView

/**
 * Created by Deng on 2019-07-24.
 */
class Part1View(context: Context) : LinearLayout(context), IModuleView {
    private val mContext = context
    private var mPresenter: Part1Presenter? = null

    init {
        createView()
    }

    override fun setPresenter(presenter: BaseModulePresenter) {
        mPresenter = presenter as Part1Presenter
        mPresenter?.attachView(this)
    }

    private fun createView() {
        LayoutInflater.from(mContext).inflate(R.layout.layout_module_part1, this, true)

        findViewById<View>(R.id.btn1).setOnClickListener { mPresenter?.btnClick() }
    }

    fun showView() {
        visibility = View.VISIBLE
    }

    fun hideView() {
        visibility = View.GONE
    }
}