package com.gc.architecture.module

import android.os.Bundle
import android.widget.LinearLayout
import com.gc.architecture.R
import com.gc.architecture.base.BaseActivity
import com.gc.architecture.base.IBaseView
import com.gc.architecture.module.part1.Part1Presenter
import com.gc.architecture.module.part1.Part1View
import com.gc.architecture.module.part2.Part2Presenter
import com.gc.architecture.module.part2.Part2View
import com.gc.architecture.module.part3.Part3Presenter
import com.gc.architecture.module.part3.Part3View

/**
 * Created by Deng on 2019-07-23.
 */
class ModuleActivity : BaseActivity(), IBaseView {
    private lateinit var mModule: IModule

    private lateinit var mPart1Container: LinearLayout
    private lateinit var mPart2Container: LinearLayout
    private lateinit var mPart3Container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_module)

        mPart1Container = findViewById(R.id.layout_part1)
        mPart2Container = findViewById(R.id.layout_part2)
        mPart3Container = findViewById(R.id.layout_part3)

        mModule = Module(mAppContext)

        initPart1()
        initPart2()
        initPart3()
    }

    private fun initPart1() {
        val part1View = Part1View(this)
        val part1Presenter = mModule.getModuleContext().getPresenter(Part1Presenter::class.java)
        part1View.setPresenter(part1Presenter)

        mPart1Container.addView(part1View)
    }

    private fun initPart2() {
        val part2View = Part2View(this)
        val part2Presenter = mModule.getModuleContext().getPresenter(Part2Presenter::class.java)
        part2View.setPresenter(part2Presenter)

        mPart2Container.addView(part2View)
    }

    private fun initPart3() {
        val part3View = Part3View(this)
        val part3Presenter = mModule.getModuleContext().getPresenter(Part3Presenter::class.java)
        part3View.setPresenter(part3Presenter)

        mPart3Container.addView(part3View)
    }
}