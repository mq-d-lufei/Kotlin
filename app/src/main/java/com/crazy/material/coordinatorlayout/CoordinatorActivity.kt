package com.crazy.material.coordinatorlayout

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import com.crazy.activity.BaseActivity
import com.crazy.kotlin.R

class CoordinatorActivity : BaseActivity() {

    override fun getActivityLayout(): Int {
        return R.layout.activity_coordinator_layout4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setstatusBarMode()
    }

    fun setstatusBarMode() {
        //透明状态栏效果
        if (Build.VERSION.SDK_INT >= 21) {
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
    }
}